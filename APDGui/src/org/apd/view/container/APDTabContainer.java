package org.apd.view.container;

import org.apd.view.panel.EligibilityPanel;
import org.apd.view.panel.IntakePanel;

import javax.swing.*;

public class APDTabContainer extends JTabbedPane {

    public IntakePanel intakePanel;
    public EligibilityPanel eligibilityPanel;

    public APDTabContainer() {
        this.intakePanel = new IntakePanel();
        this.eligibilityPanel = new EligibilityPanel();
        this.addTab(this.intakePanel.getName(), intakePanel);
        this.addTab(this.eligibilityPanel.getName(), eligibilityPanel);
    }
}
