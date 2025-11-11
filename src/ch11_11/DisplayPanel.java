package ch11_11;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel {

    private JLabel label;
    private JTextField display;

    public DisplayPanel() {
        setLayout(new BorderLayout());

        label = new JLabel();
        label.setText("수식");

        display = new JTextField();
        display.setEditable(false);  // 직접 입력 불가
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(label, BorderLayout.WEST);
        add(display, BorderLayout.CENTER);
    }

    public JTextField getDisplay() {
        return display;
    }

    public void setText(String text) {
        display.setText(text);
    }

    public String getText() {
        return display.getText();
    }
}
