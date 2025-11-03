package ch10_5;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        // 윈도우 직접 닫기 가능
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Frame 크기 지정
        setSize(800, 600);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        for (int i = 0; i < 5; i++) {
            add(new NumberButton());
        }
    }
}
