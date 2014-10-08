package org.apd.view.panel;

import org.apd.view.components.LabeledTextField;

import javax.swing.*;
import java.awt.*;

public class MiscellaneousPanel extends JPanel {

    LabeledTextField additionalComments;
    JLabel optoutNotice;
    JCheckBox optout;

    public MiscellaneousPanel() {
        InitializeComponents();
        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(this.additionalComments);
        centerPanel.add(this.optoutNotice);
        centerPanel.add(this.optout);

        this.add(centerPanel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createBevelBorder(1));
    }

    private void InitializeComponents() {
        this.additionalComments = new LabeledTextField("Additional Comments", 30);
        this.optoutNotice = new JLabel("Occasionally, the Alliance sends notices about upcoming events and advocacy opportunities.");
        this.optout = new JCheckBox("If you would NOT like to receive this information, check this box.");
    }

    public void Reset() {
        this.additionalComments.reset();
        this.optout.setSelected(false);
    }
}
