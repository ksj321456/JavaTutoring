package ch10_5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener {

    private NumberButton numberButton;

    public ButtonActionListener(NumberButton numberButton) {
        this.numberButton = numberButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int current = Integer.parseInt(numberButton.getText());
        numberButton.setText(String.valueOf(current + 1));
    }
}
