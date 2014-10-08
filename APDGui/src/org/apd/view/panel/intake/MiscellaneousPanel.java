package org.apd.view.panel.intake;

import org.apd.view.components.LabeledTextField;

import javax.swing.*;
import java.awt.*;

public class MiscellaneousPanel extends JPanel {

    private LabeledTextField additionalComments;
    JLabel optoutNotice;
    private JCheckBox optout;

    public MiscellaneousPanel() {
        InitializeComponents();
        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(this.getAdditionalComments());
        centerPanel.add(this.optoutNotice);
        centerPanel.add(this.getOptout());

        this.add(centerPanel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createBevelBorder(1));
    }

    private void InitializeComponents() {
        this.setAdditionalComments(new LabeledTextField("Additional Comments", 30));
        this.optoutNotice = new JLabel("Occasionally, the Alliance sends notices about upcoming events and advocacy opportunities.");
        this.setOptout(new JCheckBox("If you would NOT like to receive this information, check this box."));
    }

    public void Reset() {
        this.getAdditionalComments().reset();
        this.getOptout().setSelected(false);
    }

    public LabeledTextField getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(LabeledTextField additionalComments) {
        this.additionalComments = additionalComments;
    }

    public JCheckBox getOptout() {
        return optout;
    }

    public void setOptout(JCheckBox optout) {
        this.optout = optout;
    }
}
