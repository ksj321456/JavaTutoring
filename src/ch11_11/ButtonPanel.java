package ch11_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {

    public ButtonPanel(ActionListener listener) {
        setLayout(new GridLayout(5, 4, 5, 5));
        String[] buttons = {
                "C", "UN", "BK", "/",
                "7", "8", "9", "x",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "0", ".", "=", "%"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.addActionListener(listener);
            add(btn);
        }
    }
}
