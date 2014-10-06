package org.apd.view.components;

import javax.swing.*;
import java.awt.*;

public class LabeledDropdown extends JPanel {
    private JLabel label;
    private JComboBox dropdown;

    public LabeledDropdown(String label, Object[] values) {
        this.setLayout(new BorderLayout());
        this.setLabel(new JLabel(label));
        this.setDropdown(new JComboBox(values));
        this.add(this.getLabel(), BorderLayout.WEST);
        this.add(this.getDropdown(), BorderLayout.CENTER);
        this.setMaximumSize(this.getPreferredSize());
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public void reset() {
        this.getDropdown().setSelectedIndex(0);
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JComboBox getDropdown() {
        return dropdown;
    }

    public void setDropdown(JComboBox dropdown) {
        this.dropdown = dropdown;
    }
}
