package org.apd.view.panel.intake;

import org.apd.view.components.LabeledDropdown;
import org.apd.view.components.LabeledTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemographicInformationPanel extends JPanel {

    private JLabel sectionInformation;
    private JLabel sectionDescription;
    private LabeledTextField birthdate;
    private LabeledDropdown gender;
    private LabeledTextField numPeopleLivingInHousehold;
    private JCheckBox singleParentHousehold;
    private LabeledDropdown headOfHouseGender;
    private LabeledTextField numChildrenUnder18;
    private LabeledTextField grossMonthlyIncome;
    private LabeledDropdown maritalStatus;
    private JCheckBox latino;
    private LabeledDropdown ethnicity;
    private JCheckBox limitedEnglish;
    private JCheckBox immigrant;
    private JCheckBox employed;
    private LabeledDropdown workStatus;
    private LabeledTextField demographicComments;
    private JCheckBox military;

    public DemographicInformationPanel() {
        InitializeComponents();
        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(this.getSectionDescription());
        centerPanel.add(this.getBirthdate());
        centerPanel.add(this.getGender());
        centerPanel.add(this.getNumPeopleLivingInHousehold());
        centerPanel.add(this.getSingleParentHousehold());
        centerPanel.add(this.getHeadOfHouseGender());
        centerPanel.add(this.getNumChildrenUnder18());
        centerPanel.add(this.getGrossMonthlyIncome());
        centerPanel.add(this.getMaritalStatus());
        centerPanel.add(this.getLatino());
        centerPanel.add(this.getEthnicity());
        centerPanel.add(this.getLimitedEnglish());
        centerPanel.add(this.getImmigrant());
        centerPanel.add(this.getEmployed());
        centerPanel.add(this.getWorkStatus());
        centerPanel.add(this.getDemographicComments());
        centerPanel.add(this.getMilitary());

        this.add(this.getSectionInformation(), BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createBevelBorder(1));
    }

    private void InitializeComponents() {
        this.setSectionInformation(new JLabel("Demographic Information"));
        this.setSectionDescription(new JLabel("<html>This information is used for reporting general statistics to the community and to our funders about the people we serve. Your individual information is kept confidential.</html>"));
        this.setBirthdate(new LabeledTextField("Birthdate", 10));
        this.setGender(new LabeledDropdown("Gender", new String[]{"Male", "Female", "Other"}));
        this.setNumPeopleLivingInHousehold(new LabeledTextField("Number of people living in your household (including yourself)", 5));
        this.setSingleParentHousehold(new JCheckBox("Are you in a single parent household"));
        this.getSingleParentHousehold().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox box = (JCheckBox) e.getSource();
                if (box.isSelected()) {
                    getHeadOfHouseGender().setVisible(true);
                } else {
                    getHeadOfHouseGender().setVisible(false);
                    getHeadOfHouseGender().reset();
                }
            }
        });
        this.setHeadOfHouseGender(new LabeledDropdown("         If yes, what is the head of house gender?", new String[]{"Male", "Female", "Other"}));
        this.getHeadOfHouseGender().setVisible(false);
        this.setNumChildrenUnder18(new LabeledTextField("Number of children under 18 in the household", 5));
        this.setGrossMonthlyIncome(new LabeledTextField("What is your gross monthly household income", 10));
        this.setMaritalStatus(new LabeledDropdown("Marital Status", new String[]{"Single", "Married/Domestic Partner", "Separated", "Divorced", "Widowed"}));
        this.setLatino(new JCheckBox("Are you Latino/Hispanic?"));

        this.setEthnicity(new LabeledDropdown("Race/Ethnicity", new String[]{"African-American/Black", "American Indian/Alaska Native",
                "Asian", "Caucasian/White", "Hispanic/Latino", "Pacific Islander/Native Hawaiian", "Two or more races", "Other/Unknown"}));
        this.setLimitedEnglish(new JCheckBox("Are you limited in your ability to communicate in English?"));
        this.setImmigrant(new JCheckBox("Are you an immigrant, refugee, or new arrival to this country?"));
        this.setEmployed(new JCheckBox("Are you currently employed?"));
        this.setWorkStatus(new LabeledDropdown("Please specify work status:", new String[]{"Full-Time", "Part-Time", "Looking for a job",
                "Student/In a program", "Retired", "Participating in a segregated work/day program", "Unknown", "Other Employment"}));
        this.setDemographicComments(new LabeledTextField("Comments", 20));
        this.setMilitary(new JCheckBox("Have you ever served on active duty in the U.S. military (including National Guard or Reserves)?"));

        // Set alignments
        this.getSectionInformation().setHorizontalAlignment(JLabel.CENTER);
        this.getSectionInformation().setVerticalAlignment(JLabel.CENTER);
    }

    public void Reset() {
        this.getBirthdate().reset();
        this.getGender().reset();
        this.getNumPeopleLivingInHousehold().reset();
        this.getSingleParentHousehold().setSelected(false);
        this.getHeadOfHouseGender().reset();
        this.getHeadOfHouseGender().setVisible(false);
        this.getNumChildrenUnder18().reset();
        this.getGrossMonthlyIncome().reset();
        this.getMaritalStatus().reset();
        this.getLatino().setSelected(false);
        this.getEthnicity().reset();
        this.getLimitedEnglish().setSelected(false);
        this.getImmigrant().setSelected(false);
        this.getEmployed().setSelected(false);
        this.getWorkStatus().reset();
        this.getDemographicComments().reset();
        this.getMilitary().setSelected(false);
    }

    public JLabel getSectionInformation() {
        return sectionInformation;
    }

    public void setSectionInformation(JLabel sectionInformation) {
        this.sectionInformation = sectionInformation;
    }

    public JLabel getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(JLabel sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public LabeledTextField getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LabeledTextField birthdate) {
        this.birthdate = birthdate;
    }

    public LabeledDropdown getGender() {
        return gender;
    }

    public void setGender(LabeledDropdown gender) {
        this.gender = gender;
    }

    public LabeledTextField getNumPeopleLivingInHousehold() {
        return numPeopleLivingInHousehold;
    }

    public void setNumPeopleLivingInHousehold(LabeledTextField numPeopleLivingInHousehold) {
        this.numPeopleLivingInHousehold = numPeopleLivingInHousehold;
    }

    public JCheckBox getSingleParentHousehold() {
        return singleParentHousehold;
    }

    public void setSingleParentHousehold(JCheckBox singleParentHousehold) {
        this.singleParentHousehold = singleParentHousehold;
    }

    public LabeledDropdown getHeadOfHouseGender() {
        return headOfHouseGender;
    }

    public void setHeadOfHouseGender(LabeledDropdown headOfHouseGender) {
        this.headOfHouseGender = headOfHouseGender;
    }

    public LabeledTextField getNumChildrenUnder18() {
        return numChildrenUnder18;
    }

    public void setNumChildrenUnder18(LabeledTextField numChildrenUnder18) {
        this.numChildrenUnder18 = numChildrenUnder18;
    }

    public LabeledTextField getGrossMonthlyIncome() {
        return grossMonthlyIncome;
    }

    public void setGrossMonthlyIncome(LabeledTextField grossMonthlyIncome) {
        this.grossMonthlyIncome = grossMonthlyIncome;
    }

    public LabeledDropdown getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(LabeledDropdown maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public JCheckBox getLatino() {
        return latino;
    }

    public void setLatino(JCheckBox latino) {
        this.latino = latino;
    }

    public LabeledDropdown getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(LabeledDropdown ethnicity) {
        this.ethnicity = ethnicity;
    }

    public JCheckBox getLimitedEnglish() {
        return limitedEnglish;
    }

    public void setLimitedEnglish(JCheckBox limitedEnglish) {
        this.limitedEnglish = limitedEnglish;
    }

    public JCheckBox getImmigrant() {
        return immigrant;
    }

    public void setImmigrant(JCheckBox immigrant) {
        this.immigrant = immigrant;
    }

    public JCheckBox getEmployed() {
        return employed;
    }

    public void setEmployed(JCheckBox employed) {
        this.employed = employed;
    }

    public LabeledDropdown getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(LabeledDropdown workStatus) {
        this.workStatus = workStatus;
    }

    public LabeledTextField getDemographicComments() {
        return demographicComments;
    }

    public void setDemographicComments(LabeledTextField demographicComments) {
        this.demographicComments = demographicComments;
    }

    public JCheckBox getMilitary() {
        return military;
    }

    public void setMilitary(JCheckBox military) {
        this.military = military;
    }
}
