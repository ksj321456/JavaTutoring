package ch11_11;

import javax.swing.*;
import java.awt.*;

class ResultPanel extends JPanel {
    private JLabel resultLabel;

    public ResultPanel() {
        setLayout(new BorderLayout());
        resultLabel = new JLabel("계산 결과: ");
        resultLabel.setOpaque(true);
        resultLabel.setBackground(Color.YELLOW);
        add(resultLabel, BorderLayout.CENTER);
    }

    public void setResult(String text) {
        resultLabel.setText("계산 결과: " + text);
    }
}
