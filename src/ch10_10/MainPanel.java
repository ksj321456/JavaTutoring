package ch10_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainPanel extends JFrame {

    public MainPanel() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
                    addColorBlock();
                }
            }
        });
    }

    private void addColorBlock() {
        ColorBlock block = new ColorBlock(100, 100);
        add(block);
        repaint();
    }
}
