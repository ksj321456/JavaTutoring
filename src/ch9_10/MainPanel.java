package ch9_10;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JFrame {
    public MainPanel() {
        setTitle("West Grid 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        add(new WestPanel(), BorderLayout.WEST);
        add(new CenterPanel(), BorderLayout.CENTER);
    }
}
