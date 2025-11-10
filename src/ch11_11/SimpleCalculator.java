package ch11_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimpleCalculator extends JFrame {
    private DisplayPanel displayPanel;
    private ResultPanel resultPanel;
    private String currentInput = "";
    private String operator = "";

    public SimpleCalculator() {
        setTitle("간단한 계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        displayPanel = new DisplayPanel();
        add(displayPanel, BorderLayout.NORTH);

        resultPanel = new ResultPanel();
        add(resultPanel, BorderLayout.SOUTH);

        ButtonPanel buttonPanel = new ButtonPanel(new ButtonListener());
        add(buttonPanel, BorderLayout.CENTER);

        setSize(350, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.matches("[0-9]") || command.equals(".")) {
                currentInput += command;
                displayPanel.setText(currentInput);
            }
            else if (command.matches("[+\\-*/%x]")) {
                if (operator.isEmpty()) {
                    operator = command;
                    currentInput += command;
                    displayPanel.setText(currentInput);
                } else {
                    displayPanel.setText("한 개의 연산만 가능");
                    resultPanel.setResult("한 개의 연산만 가능");
                }
            }
            else if (command.equals("=")) {
                calculate();
            }
            else if (command.equals("C")) {
                clear();
            }
            else if (command.equals("UN")) {
                backspace();
            }
        }

        private void calculate() {
            if (operator.isEmpty() || !currentInput.contains(operator)) return;

            String[] parts = currentInput.split("[\\+\\-x*/%]");
            if (parts.length != 2 || parts[1].isEmpty()) return;

            try {
                double num1 = Double.parseDouble(parts[0]);
                double num2 = Double.parseDouble(parts[1]);
                double result = 0;

                switch (operator) {
                    case "+": result = num1 + num2; break;
                    case "-": result = num1 - num2; break;
                    case "x": result = num1 * num2; break;
                    case "/":
                        if (num2 == 0) {
                            displayPanel.setText("0으로 나눌 수 없음");
                            resultPanel.setResult("0으로 나눌 수 없음");
                            reset();
                            return;
                        }
                        result = num1 / num2; break;
                    case "%": result = num1 % num2; break;
                }

                displayPanel.setText(String.valueOf(result));
                resultPanel.setResult(String.valueOf(result));
                reset();
                currentInput = String.valueOf(result);
            } catch (Exception ex) {
                displayPanel.setText("오류");
                resultPanel.setResult("오류");
                reset();
            }
        }

        private void clear() {
            currentInput = "";
            operator = "";
            displayPanel.setText("");
            resultPanel.setResult("");
        }

        private void backspace() {
            if (!currentInput.isEmpty()) {
                currentInput = currentInput.substring(0, currentInput.length() - 1);
                displayPanel.setText(currentInput);
            }
        }

        private void reset() {
            operator = "";
        }
    }
}