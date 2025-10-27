package ch9_10;

import javax.swing.*;
import java.awt.*;

public class WestPanel extends JPanel {

    public WestPanel() {
        // 10행 1열 GridLayout
        super(new GridLayout(10, 1));

        // 버튼 색깔 배열
        Color[] colors = {
                Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN,
                Color.BLUE, Color.MAGENTA, Color.PINK, Color.LIGHT_GRAY, Color.DARK_GRAY
        };

        // 버튼 생성
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton();
            button.setBackground(colors[i]);
            button.setOpaque(true);
            button.setBorderPainted(false);
            this.add(button);
        }
    }
}
