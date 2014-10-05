package org.apd.view.components;

import javax.swing.*;
import java.awt.*;

public class LabeledTextField extends JPanel {
    private JLabel label;
    private JTextField textField;

    public LabeledTextField(String label, int textWidth) {
        this.setLayout(new BorderLayout());
        this.setLabel(new JLabel(label));
        this.setTextField(new JTextField(textWidth));
        this.add(this.getLabel(), BorderLayout.WEST);
        this.add(this.getTextField(), BorderLayout.CENTER);
        this.setMaximumSize(this.getPreferredSize());
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }
}
