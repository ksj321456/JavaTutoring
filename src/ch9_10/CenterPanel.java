package ch9_10;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel {

    public CenterPanel() {
        setLayout(null); // 절대 좌표 사용
        setBackground(Color.WHITE);

        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * 200) + 50;
            int y = (int) (Math.random() * 200) + 50;

            int number = (int) (Math.random() * 10);
            JLabel label = new JLabel(String.valueOf(number));
            label.setBounds(x, y, 30, 30); // 위치 + 크기
            label.setOpaque(true);
            label.setBackground(Color.WHITE);      // 배경 흰색
            label.setForeground(Color.RED);        // 글자 빨간색
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);


            add(label);
        }
    }
}
