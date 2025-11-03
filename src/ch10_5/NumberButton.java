package ch10_5;

import javax.swing.*;

public class NumberButton extends JButton {

    public NumberButton() {
        super("0");

        ButtonActionListener buttonActionListener = new ButtonActionListener(this);

        // 리스너 등록
        addActionListener(buttonActionListener);
    }
}
