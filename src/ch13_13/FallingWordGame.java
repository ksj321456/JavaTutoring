package ch13_13;

import javax.swing.*;
import java.awt.*;

public class FallingWordGame extends JFrame {

    private JLabel wordLabel = new JLabel("");
    private JTextField inputField = new JTextField();
    private JLabel resultLabel = new JLabel("");

    private final String[] words = Words.words;

    private int currentIndex = 0;
    private int y = 0;

    private volatile boolean running = true;
    private Thread fallingThread;

    public FallingWordGame() {
        setTitle("떨어지는 단어 맞추기 (Thread 버전)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(null);

        resultLabel.setBounds(10, 10, 260, 30);
        add(resultLabel);

        wordLabel.setBounds(10, 50, 260, 30);
        wordLabel.setFont(new Font("Dialog", Font.ITALIC, 20));
        wordLabel.setForeground(Color.MAGENTA);
        add(wordLabel);

        inputField.setBounds(10, 320, 260, 30);
        add(inputField);

        inputField.addActionListener(e -> checkWord());

        startGame();
        setVisible(true);
    }

    private void startGame() {
        showNewWord();

        fallingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (!running) continue;

                    y += 10;

                    wordLabel.setLocation(10, y);

                    // 바닥 닿음 → 실패
                    if (y > 260) {
                        running = false;
                        resultLabel.setText("시간초과실패");
                        nextWord();
                    }
                }
            }
        });

        fallingThread.start();
    }

    private void checkWord() {
        String typed = inputField.getText();
        String correct = words[currentIndex];

        if (typed.equals(correct)) {
            running = false;
            resultLabel.setText("성공!");
            nextWord();
        } else {
            resultLabel.setText("틀렸습니다!");
        }

        inputField.setText("");
    }

    private void nextWord() {
        new Thread(() -> {
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 다음 단어 선택은 랜덤으로
            currentIndex = (int)(Math.random() * words.length);

            showNewWord();
            running = true;
        }).start();
    }

    private void showNewWord() {
        y = 50;
        wordLabel.setLocation(10, y);
        wordLabel.setText(words[currentIndex]);
        inputField.setText("");
        resultLabel.setText(" ");
    }

}
