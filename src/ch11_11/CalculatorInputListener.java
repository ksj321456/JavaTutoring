package ch11_11;

import java.awt.event.*;
import javax.swing.*;

public class CalculatorInputListener extends KeyAdapter implements ActionListener {

    private DisplayPanel displayPanel;
    private ResultPanel resultPanel;

    private String currentInput = "";
    private String operator = "";

    public CalculatorInputListener(DisplayPanel displayPanel, ResultPanel resultPanel) {
        this.displayPanel = displayPanel;
        this.resultPanel = resultPanel;

        // DisplayPanel의 JTextField에 포커스를 주고 키 입력을 받도록 설정
        JTextField field = displayPanel.getDisplay();
        field.setFocusable(true);
        field.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        processInput(command);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();

        if (Character.isDigit(keyChar) || "+-x*/.%".indexOf(keyChar) != -1) {
            processInput(String.valueOf(keyChar));
        } else if (keyChar == '\b') { // 백스페이스
            backspace();
        } else if (keyChar == '\n') { // 엔터
            calculate();
        }
    }

    private void processInput(String input) {
        if (input.matches("[0-9]") || input.equals(".")) {
            currentInput += input;
            displayPanel.setText(currentInput);
        } else if (input.matches("[+\\-x*/%]")) {
            if (operator.isEmpty()) {
                operator = input;
                currentInput += input;
                displayPanel.setText(currentInput);
            } else {
                displayPanel.setText("한 개의 연산만 가능");
                resultPanel.setResult("한 개의 연산만 가능");
            }
        } else if (input.equals("=")) {
            calculate();
        } else if (input.equals("C")) {
            clear();
        } else if (input.equals("UN")) {
            backspace();
        }
    }

    // ---------------- 계산 ----------------
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
            currentInput = String.valueOf(result);
            reset();
        } catch (Exception ex) {
            displayPanel.setText("오류");
            resultPanel.setResult("오류");
            reset();
        }
    }

    // ---------------- 클리어 ----------------
    private void clear() {
        currentInput = "";
        operator = "";
        displayPanel.setText("");
        resultPanel.setResult("");
    }

    // ---------------- 백스페이스 ----------------
    private void backspace() {
        if (!currentInput.isEmpty()) {
            currentInput = currentInput.substring(0, currentInput.length() - 1);
            displayPanel.setText(currentInput);
        }
    }

    // ---------------- 리셋 ----------------
    private void reset() {
        operator = "";
    }
}
