package ch10_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener extends MouseAdapter {

    private final JComponent target;

    private Point initialClick;

    private int startX, startY;

    public MyMouseListener(JComponent target) {
        this.target = target;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        initialClick = e.getPoint();
        startX = target.getX();
        startY = target.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int dx = e.getX() - initialClick.x;
        int dy = e.getY() - initialClick.y;
        target.setLocation(startX + dx, startY + dy);
    }
}
