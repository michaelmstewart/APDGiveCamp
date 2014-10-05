package org.apd.view.panel;

import org.apd.view.components.LabeledTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdditionalInformationPanel extends JPanel {

    JLabel sectionInformation;
    JLabel under21;
    JCheckBox plan504;
    JCheckBox planIep;
    JCheckBox isRegisteredVoter;
    JCheckBox becomeRegisteredVoter;
    LabeledTextField howLearnedAboutAlliance;
    LabeledTextField referredAgency;

    JCheckBox accessAssistiveTechnology;
    JCheckBox accessHealthCare;
    JCheckBox accessTransportation;

    public AdditionalInformationPanel() {
        InitializeComponents();
        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(this.under21);
        centerPanel.add(this.plan504);
        centerPanel.add(this.planIep);
        centerPanel.add(this.isRegisteredVoter);
        centerPanel.add(this.becomeRegisteredVoter);
        centerPanel.add(this.howLearnedAboutAlliance);
        centerPanel.add(this.referredAgency);

        centerPanel.add(this.accessAssistiveTechnology);
        centerPanel.add(this.accessHealthCare);
        centerPanel.add(this.accessTransportation);

//        homeTypeGridBag.add(this.housingTypeAssistedLiving);
//        homeTypeGridBag.add(this.housingTypeDependentOnFamilyOrFriends);
//        homeTypeGridBag.add(this.housingTypeHomeless);
//        homeTypeGridBag.add(this.housingTypeIndependent);
//        homeTypeGridBag.add(this.housingTypeInstitution);
//        homeTypeGridBag.add(this.housingTypeOther);
//        homeTypeGridBag.add(this.housingTypeRentSubsidized);
//        homeTypeGridBag.add(this.housingTypeRentUnsubsidized);
//        centerPanel.add(this.homelessPanel);
//
//        centerPanel.add(this.atRiskMovingNursing);

        this.add(this.sectionInformation, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createBevelBorder(1));
    }

    private void InitializeComponents() {
        this.sectionInformation = new JLabel("Additional Information");
        this.under21 = new JLabel("If you are under 21, do you have a:");
        this.plan504 = new JCheckBox("504 Plan");
        this.planIep = new JCheckBox("IEP");
        this.isRegisteredVoter = new JCheckBox("Are you registered to vote?");
        this.isRegisteredVoter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox box = (JCheckBox)e.getSource();
                if(box.isSelected()) {
                    becomeRegisteredVoter.setVisible(false);
                    becomeRegisteredVoter.setSelected(false);
                } else {
                    becomeRegisteredVoter.setVisible(true);
                }
            }
        });
        this.becomeRegisteredVoter = new JCheckBox("Would you like to become a registered voter?");

        this.howLearnedAboutAlliance = new LabeledTextField("How did you learn about the Alliance?", 20);
        this.referredAgency = new LabeledTextField("Were you referred from a specific agency? (If so, which)", 15);

        this.accessAssistiveTechnology = new JCheckBox("Do you have access to any assistive technology you may need?");
        this.accessHealthCare = new JCheckBox("Do you have access to needed health care?");
        this.accessTransportation = new JCheckBox("Do you have access to needed transportation?");

        // Set alignments
        this.sectionInformation.setHorizontalAlignment(JLabel.CENTER);
        this.sectionInformation.setVerticalAlignment(JLabel.CENTER);
    }
}
