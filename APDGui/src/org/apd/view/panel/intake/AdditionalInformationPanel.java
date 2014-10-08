package org.apd.view.panel.intake;

import org.apd.view.components.LabeledDropdown;
import org.apd.view.components.LabeledTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdditionalInformationPanel extends JPanel {

    private JLabel sectionInformation;
    private JLabel under21;
    private JCheckBox plan504;
    private JCheckBox planIep;
    private JCheckBox isRegisteredVoter;
    private JCheckBox becomeRegisteredVoter;
    private LabeledTextField howLearnedAboutAlliance;
    private LabeledTextField referredAgency;
    private LabeledDropdown alternateFormats;
    private JCheckBox accessAssistiveTechnology;
    private JCheckBox accessHealthCare;
    private JCheckBox accessTransportation;

    public AdditionalInformationPanel() {
        InitializeComponents();
        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(this.getUnder21());
        centerPanel.add(this.getPlan504());
        centerPanel.add(this.getPlanIep());
        centerPanel.add(this.getIsRegisteredVoter());
        centerPanel.add(this.getBecomeRegisteredVoter());
        centerPanel.add(this.getHowLearnedAboutAlliance());
        centerPanel.add(this.getReferredAgency());
        centerPanel.add(this.getAlternateFormats());
        centerPanel.add(this.getAccessAssistiveTechnology());
        centerPanel.add(this.getAccessHealthCare());
        centerPanel.add(this.getAccessTransportation());

        this.add(this.getSectionInformation(), BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createBevelBorder(1));
    }

    private void InitializeComponents() {
        this.setSectionInformation(new JLabel("Additional Information"));
        this.setUnder21(new JLabel("If you are under 21, do you have a:"));
        this.setPlan504(new JCheckBox("504 Plan"));
        this.setPlanIep(new JCheckBox("IEP"));
        this.setIsRegisteredVoter(new JCheckBox("Are you registered to vote?"));
        this.getIsRegisteredVoter().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox box = (JCheckBox) e.getSource();
                if (box.isSelected()) {
                    getBecomeRegisteredVoter().setVisible(false);
                    getBecomeRegisteredVoter().setSelected(false);
                } else {
                    getBecomeRegisteredVoter().setVisible(true);
                }
            }
        });
        this.setBecomeRegisteredVoter(new JCheckBox("Would you like to become a registered voter?"));

        this.setHowLearnedAboutAlliance(new LabeledTextField("How did you learn about the Alliance?", 20));
        this.setReferredAgency(new LabeledTextField("Were you referred from a specific agency? (If so, which)", 15));
        this.setAlternateFormats(new LabeledDropdown("Alternate formats requested", new String[]{"None", "Standard", "Large Print", "Braille",
                "Audio Tape", "CD", "Email - Standard Email", "Email - Large Print"}));
        this.setAccessAssistiveTechnology(new JCheckBox("Do you have access to any assistive technology you may need?"));
        this.setAccessHealthCare(new JCheckBox("Do you have access to needed health care?"));
        this.setAccessTransportation(new JCheckBox("Do you have access to needed transportation?"));

        // Set alignments
        this.getSectionInformation().setHorizontalAlignment(JLabel.CENTER);
        this.getSectionInformation().setVerticalAlignment(JLabel.CENTER);
    }

    public void Reset() {
        this.getPlan504().setSelected(false);
        this.getPlanIep().setSelected(false);
        this.getIsRegisteredVoter().setSelected(false);
        this.getBecomeRegisteredVoter().setSelected(false);
        this.getHowLearnedAboutAlliance().reset();
        this.getReferredAgency().reset();
        this.getAlternateFormats().reset();
        this.getAccessAssistiveTechnology().setSelected(false);
        this.getAccessHealthCare().setSelected(false);
        this.getAccessTransportation().setSelected(false);
    }

    public JLabel getSectionInformation() {
        return sectionInformation;
    }

    public void setSectionInformation(JLabel sectionInformation) {
        this.sectionInformation = sectionInformation;
    }

    public JLabel getUnder21() {
        return under21;
    }

    public void setUnder21(JLabel under21) {
        this.under21 = under21;
    }

    public JCheckBox getPlan504() {
        return plan504;
    }

    public void setPlan504(JCheckBox plan504) {
        this.plan504 = plan504;
    }

    public JCheckBox getPlanIep() {
        return planIep;
    }

    public void setPlanIep(JCheckBox planIep) {
        this.planIep = planIep;
    }

    public JCheckBox getIsRegisteredVoter() {
        return isRegisteredVoter;
    }

    public void setIsRegisteredVoter(JCheckBox isRegisteredVoter) {
        this.isRegisteredVoter = isRegisteredVoter;
    }

    public JCheckBox getBecomeRegisteredVoter() {
        return becomeRegisteredVoter;
    }

    public void setBecomeRegisteredVoter(JCheckBox becomeRegisteredVoter) {
        this.becomeRegisteredVoter = becomeRegisteredVoter;
    }

    public LabeledTextField getHowLearnedAboutAlliance() {
        return howLearnedAboutAlliance;
    }

    public void setHowLearnedAboutAlliance(LabeledTextField howLearnedAboutAlliance) {
        this.howLearnedAboutAlliance = howLearnedAboutAlliance;
    }

    public LabeledTextField getReferredAgency() {
        return referredAgency;
    }

    public void setReferredAgency(LabeledTextField referredAgency) {
        this.referredAgency = referredAgency;
    }

    public LabeledDropdown getAlternateFormats() {
        return alternateFormats;
    }

    public void setAlternateFormats(LabeledDropdown alternateFormats) {
        this.alternateFormats = alternateFormats;
    }

    public JCheckBox getAccessAssistiveTechnology() {
        return accessAssistiveTechnology;
    }

    public void setAccessAssistiveTechnology(JCheckBox accessAssistiveTechnology) {
        this.accessAssistiveTechnology = accessAssistiveTechnology;
    }

    public JCheckBox getAccessHealthCare() {
        return accessHealthCare;
    }

    public void setAccessHealthCare(JCheckBox accessHealthCare) {
        this.accessHealthCare = accessHealthCare;
    }

    public JCheckBox getAccessTransportation() {
        return accessTransportation;
    }

    public void setAccessTransportation(JCheckBox accessTransportation) {
        this.accessTransportation = accessTransportation;
    }
}
