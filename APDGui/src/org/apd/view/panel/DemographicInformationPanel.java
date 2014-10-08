package org.apd.view.panel;

import org.apd.view.components.LabeledDropdown;
import org.apd.view.components.LabeledTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemographicInformationPanel extends JPanel {

    JLabel sectionInformation;
    JLabel sectionDescription;
    LabeledTextField birthdate;
    LabeledDropdown gender;
    LabeledTextField numPeopleLivingInHousehold;
    JCheckBox singleParentHousehold;
    LabeledDropdown headOfHouseGender;
    LabeledTextField numChildrenUnder18;
    LabeledTextField grossMonthlyIncome;
    LabeledDropdown maritalStatus;
    JCheckBox latino;
    LabeledDropdown ethnicity;
    JCheckBox limitedEnglish;
    JCheckBox immigrant;
    JCheckBox employed;
    LabeledDropdown workStatus;
    LabeledTextField demographicComments;
    JCheckBox military;

    public DemographicInformationPanel() {
        InitializeComponents();
        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(this.sectionDescription);
        centerPanel.add(this.birthdate);
        centerPanel.add(this.gender);
        centerPanel.add(this.numPeopleLivingInHousehold);
        centerPanel.add(this.singleParentHousehold);
        centerPanel.add(this.headOfHouseGender);
        centerPanel.add(this.numChildrenUnder18);
        centerPanel.add(this.grossMonthlyIncome);
        centerPanel.add(this.maritalStatus);
        centerPanel.add(this.latino);
        centerPanel.add(this.ethnicity);
        centerPanel.add(this.limitedEnglish);
        centerPanel.add(this.immigrant);
        centerPanel.add(this.employed);
        centerPanel.add(this.workStatus);
        centerPanel.add(this.demographicComments);
        centerPanel.add(this.military);

        this.add(this.sectionInformation, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createBevelBorder(1));
    }

    private void InitializeComponents() {
        this.sectionInformation = new JLabel("Demographic Information");
        this.sectionDescription = new JLabel("<html>This information is used for reporting general statistics to the community and to our funders about the people we serve. Your individual information is kept confidential.</html>");
        this.birthdate = new LabeledTextField("Birthdate", 10);
        this.gender = new LabeledDropdown("Gender", new String[]{"Male", "Female", "Other"});
        this.numPeopleLivingInHousehold = new LabeledTextField("Number of people living in your household (including yourself)", 5);
        this.singleParentHousehold = new JCheckBox("Are you in a single parent household");
        this.singleParentHousehold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox box = (JCheckBox)e.getSource();
                if(box.isSelected()) {
                    headOfHouseGender.setVisible(true);
                } else {
                    headOfHouseGender.setVisible(false);
                    headOfHouseGender.reset();
                }
            }
        });
        this.headOfHouseGender = new LabeledDropdown("         If yes, what is the head of house gender?", new String[]{"Male", "Female", "Other"});
        this.headOfHouseGender.setVisible(false);
        this.numChildrenUnder18 = new LabeledTextField("Number of children under 18 in the household", 5);
        this.grossMonthlyIncome = new LabeledTextField("What is your gross monthly household income", 10);
        this.maritalStatus = new LabeledDropdown("Marital Status", new String[]{"Single", "Married/Domestic Partner", "Separated", "Divorced", "Widowed"});
        this.latino = new JCheckBox("Are you Latino/Hispanic?");

        this.ethnicity = new LabeledDropdown("Race/Ethnicity", new String[]{"African-American/Black", "American Indian/Alaska Native",
                "Asian", "Caucasian/White", "Hispanic/Latino", "Pacific Islander/Native Hawaiian", "Two or more races", "Other/Unknown"});
        this.limitedEnglish = new JCheckBox("Are you limited in your ability to communicate in English?");
        this.immigrant = new JCheckBox("Are you an immigrant, refugee, or new arrival to this country?");
        this.employed = new JCheckBox("Are you currently employed?");
        this.workStatus = new LabeledDropdown("Please specify work status:", new String[]{"Full-Time", "Part-Time", "Looking for a job",
                "Student/In a program", "Retired", "Participating in a segregated work/day program", "Unknown", "Other Employment"});
        this.demographicComments = new LabeledTextField("Comments", 20);
        this.military = new JCheckBox("Have you ever served on active duty in the U.S. military (including National Guard or Reserves)?");

        // Set alignments
        this.sectionInformation.setHorizontalAlignment(JLabel.CENTER);
        this.sectionInformation.setVerticalAlignment(JLabel.CENTER);
    }

    public void Reset() {
        this.birthdate.reset();
        this.gender.reset();
        this.numPeopleLivingInHousehold.reset();
        this.singleParentHousehold.setSelected(false);
        this.headOfHouseGender.reset();
        this.headOfHouseGender.setVisible(false);
        this.numChildrenUnder18.reset();
        this.grossMonthlyIncome.reset();
        this.maritalStatus.reset();
        this.latino.setSelected(false);
        this.ethnicity.reset();
        this.limitedEnglish.setSelected(false);
        this.immigrant.setSelected(false);
        this.employed.setSelected(false);
        this.workStatus.reset();
        this.demographicComments.reset();
        this.military.setSelected(false);
    }
}
