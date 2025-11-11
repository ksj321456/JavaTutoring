package ch10_10;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ColorBlock extends JLabel {

    private static final int SIZE = 80;

    public ColorBlock(int x, int y) {
        setBounds(x, y, SIZE, SIZE);
        setOpaque(true);
        setBackground(generateRandomColor());

        // 마우스 리스너 등록
        MyMouseListener ml = new MyMouseListener(this);

        addMouseListener(ml);

        addMouseMotionListener(ml);
    }

    private Color generateRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
