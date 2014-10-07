package org.apd.view.panel;

import org.apd.model.domain.County;
import org.apd.model.domain.State;
import org.apd.model.parsers.LocaleParser;
import org.apd.view.components.LabeledDropdown;
import org.apd.view.components.LabeledTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class HousingInformationPanel extends JPanel {
    static LocaleParser LocaleParser;
    JLabel sectionInformation;
    LabeledTextField homeAddress1;
    LabeledTextField homeAddress2;
    LabeledTextField homeCity;
    LabeledDropdown homeState;
    LabeledTextField homeZipCode;
    LabeledDropdown homeCounty;

    JCheckBox isMailingAddressDifferent;
    JPanel mailingAddressPanel;
    LabeledTextField mailAddress1;
    LabeledTextField mailAddress2;
    LabeledTextField mailCity;
    LabeledDropdown mailState;
    LabeledTextField mailZipCode;
    LabeledDropdown mailCounty;

    LabeledTextField email;
    LabeledTextField phone1;
    JRadioButton phone1HomeType;
    JRadioButton phone1WorkType;
    JRadioButton phone1MobileType;
    JRadioButton phone1TTYType;
    JRadioButton phone1FaxType;
    LabeledTextField phone2;
    LabeledTextField extension1;
    LabeledTextField extension2;
    LabeledTextField emergencyContactName;
    LabeledTextField emergencyContactPhone;
    ButtonGroup housingType;
    JRadioButton housingTypeHomeless;
    JRadioButton housingTypeInstitution;
    JRadioButton housingTypeDependentOnFamilyOrFriends;
    JRadioButton housingTypeAssistedLiving;
    JRadioButton housingTypeIndependent;
    JRadioButton housingTypeOther;
    JRadioButton housingTypeRentSubsidized;
    JRadioButton housingTypeRentUnsubsidized;
    JPanel homelessPanel;
    LabeledTextField timesHomeless;
    LabeledTextField lengthRecentHomeless;
    JCheckBox atRiskMovingNursing;

    public HousingInformationPanel() {
        InitializeComponents();
        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(this.homeAddress1);
        centerPanel.add(this.homeAddress2);
        centerPanel.add(this.homeCity);
        centerPanel.add(this.homeState);
        centerPanel.add(this.homeZipCode);
        centerPanel.add(this.homeCounty);
        centerPanel.add(this.isMailingAddressDifferent);
        centerPanel.add(this.mailingAddressPanel);
        centerPanel.add(this.email);
        centerPanel.add(this.phone1);
        centerPanel.add(this.phone2);
        centerPanel.add(this.emergencyContactName);
        centerPanel.add(this.emergencyContactPhone);

        JPanel homeTypeGridBag = new JPanel();
        centerPanel.add(new JLabel("What type of housing are you currently living in?"));
        homeTypeGridBag.setLayout(new GridLayout(3, 3));
        homeTypeGridBag.setAlignmentX(Component.LEFT_ALIGNMENT);
        homeTypeGridBag.add(this.housingTypeAssistedLiving);
        homeTypeGridBag.add(this.housingTypeDependentOnFamilyOrFriends);
        homeTypeGridBag.add(this.housingTypeHomeless);
        homeTypeGridBag.add(this.housingTypeIndependent);
        homeTypeGridBag.add(this.housingTypeInstitution);
        homeTypeGridBag.add(this.housingTypeOther);
        homeTypeGridBag.add(this.housingTypeRentSubsidized);
        homeTypeGridBag.add(this.housingTypeRentUnsubsidized);
        centerPanel.add(homeTypeGridBag);
        centerPanel.add(this.homelessPanel);

        centerPanel.add(this.atRiskMovingNursing);

        this.add(this.sectionInformation, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createBevelBorder(1));
    }

    private void InitializeComponents() {
        HousingInformationPanel.LocaleParser = new LocaleParser();
        this.sectionInformation = new JLabel("Contact/HousingInformation");
        this.homeAddress1 = new LabeledTextField("Home Address Line 1", 20);
        this.homeAddress2 = new LabeledTextField("Home Address Line 2", 20);
        this.homeCity = new LabeledTextField("Home City", 10);
        this.homeZipCode = new LabeledTextField("Home Zip Code", 5);

        ArrayList<String> states = new ArrayList<String>();
        for(String key : HousingInformationPanel.LocaleParser.getStatesByShortCode().keySet()) {
            states.add(key);
        }
        states.add("");
        Collections.sort(states);

        this.homeState = new LabeledDropdown("Home State", states.toArray());
        this.homeState.getDropdown().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String state = ((JComboBox) e.getSource()).getSelectedItem().toString();
                ArrayList<String> counties = new ArrayList<String>();
                homeCounty.getDropdown().removeAllItems();
                homeCounty.getDropdown().setPreferredSize(null);
                for (County county : HousingInformationPanel.LocaleParser.getCountiesSetByState().get(state)) {
                    counties.add(county.getName());
                }
                Collections.sort(counties);
                String longestString = "";
                for (String s : counties) {
                    homeCounty.getDropdown().addItem(s);
                    if (s.length() > longestString.length()) {
                        longestString = s;
                    }
                }

                // TODO: figure out how to resize the country dropdown
                /*
                Dimension preferredSize = homeCounty.getDropdown().getPreferredSize();
                preferredSize.height = 15;
                homeCounty.getDropdown().setPreferredSize(preferredSize);//homeCounty.getDropdown().getPreferredSize());
                System.out.println(longestString);
                //homeCounty.getDropdown().setPrototypeDisplayValue(longestString);
                homeCounty.getDropdown().setModel(new DefaultComboBoxModel(counties.toArray()));
                homeCounty.getDropdown().doLayout();
                homeCounty.getDropdown().revalidate();
                homeCounty.getDropdown().repaint();*/
            }
        });

        this.homeCounty = new LabeledDropdown("Home County", new String[]{"starting string"});
        this.homeState.getDropdown().setSelectedItem("WA");
        this.homeCounty.getDropdown().setSelectedItem("King");

        this.isMailingAddressDifferent = new JCheckBox("Is Mailing Address Different?");
        this.isMailingAddressDifferent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox box = (JCheckBox)e.getSource();
                if(box.isSelected()) {
                    mailingAddressPanel.setVisible(true);
                } else {
                    resetmailingAddress();
                }
            }
        });

        mailingAddressPanel = new JPanel();
        mailingAddressPanel.setLayout(new BoxLayout(mailingAddressPanel, BoxLayout.PAGE_AXIS));
        this.mailAddress1 = new LabeledTextField("Mailing Address Line 1", 20);
        this.mailAddress2 = new LabeledTextField("Mailing Address Line 2", 20);
        this.mailCity = new LabeledTextField("Mailing City", 10);
        this.mailZipCode = new LabeledTextField("Mailing Zip Code", 5);

        ArrayList<String> mailStates = new ArrayList<String>();
        for(String key : HousingInformationPanel.LocaleParser.getStatesByShortCode().keySet()) {
            mailStates.add(key);
        }
        mailStates.add("");
        Collections.sort(mailStates);

        this.mailState = new LabeledDropdown("Mailing State", mailStates.toArray());
        this.mailState.getDropdown().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String state = ((JComboBox) e.getSource()).getSelectedItem().toString();
                if(state != null && !state.equals("")) {
                    ArrayList<String> counties = new ArrayList<String>();
                    mailCounty.getDropdown().removeAllItems();
                    mailCounty.getDropdown().setPreferredSize(null);
                    for (County county : HousingInformationPanel.LocaleParser.getCountiesSetByState().get(state)) {
                        counties.add(county.getName());
                    }
                    Collections.sort(counties);
                    String longestString = "";
                    for (String s : counties) {
                        mailCounty.getDropdown().addItem(s);
                        if (s.length() > longestString.length()) {
                            longestString = s;
                        }
                    }
                }
            }
        });

        this.mailCounty = new LabeledDropdown("Mailing County", new String[]{"          "});
        mailingAddressPanel.add(this.mailAddress1);
        mailingAddressPanel.add(this.mailAddress2);
        mailingAddressPanel.add(this.mailCity);
        mailingAddressPanel.add(this.mailState);
        mailingAddressPanel.add(this.mailZipCode);
        mailingAddressPanel.add(this.mailCounty);
        mailingAddressPanel.setVisible(false);

        this.email = new LabeledTextField("Email address", 20);
        this.phone1 = new LabeledTextField("Home", 10);
        this.phone2 = new LabeledTextField("Mobile Phone", 10);
        this.emergencyContactName = new LabeledTextField("Emergency contact full name", 20);
        this.emergencyContactPhone = new LabeledTextField("Emergency contact phone number", 20);

        this.housingType = new ButtonGroup();
        this.housingTypeHomeless = new JRadioButton("Homeless");
        this.housingTypeInstitution = new JRadioButton("Institution");
        this.housingTypeDependentOnFamilyOrFriends = new JRadioButton("Dependent on Family/Friends");
        this.housingTypeAssistedLiving = new JRadioButton("Assisted Living");
        this.housingTypeIndependent = new JRadioButton("Independent");
        this.housingTypeIndependent.setSelected(true);
        this.housingTypeOther = new JRadioButton("Other");
        this.housingTypeRentSubsidized = new JRadioButton("Rent - Subsidized");
        this.housingTypeRentUnsubsidized = new JRadioButton("Rent - Unsubsidized");
/*
        this.housingTypeHomeless.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton)e.getSource();
                if(button.isSelected()) {
                    homelessPanel.setVisible(true);
                } else {
                    homelessPanel.setVisible(false);
                }
            }
        });
*/
        this.homelessPanel = new JPanel();
        this.homelessPanel.setLayout(new BoxLayout(this.homelessPanel, BoxLayout.PAGE_AXIS));
        this.timesHomeless = new LabeledTextField("How many times have you been homeless in the past three years?", 5);
        this.lengthRecentHomeless = new LabeledTextField("How long have you been homeless this last time?", 10);
        this.homelessPanel.add(this.timesHomeless);
        this.homelessPanel.add(this.lengthRecentHomeless);

        this.housingType.add(this.housingTypeAssistedLiving);
        this.housingType.add(this.housingTypeDependentOnFamilyOrFriends);
        this.housingType.add(this.housingTypeHomeless);
        this.housingType.add(this.housingTypeIndependent);
        this.housingType.add(this.housingTypeInstitution);
        this.housingType.add(this.housingTypeOther);
        this.housingType.add(this.housingTypeRentSubsidized);
        this.housingType.add(this.housingTypeRentUnsubsidized);
        //this.homelessPanel.setVisible(false);

        this.atRiskMovingNursing = new JCheckBox("Do you feel you are at risk for moving into a nursing facility?");
        // Set Alignments
        this.sectionInformation.setHorizontalAlignment(JLabel.CENTER);
        this.sectionInformation.setVerticalAlignment(JLabel.CENTER);
    }

    public void Reset() {
        this.homeAddress1.reset();
        this.homeAddress2.reset();
        this.homeCity.reset();
        this.homeState.getDropdown().setSelectedItem("WA");
        this.homeZipCode.reset();
        this.homeCounty.getDropdown().setSelectedItem("King");
        this.isMailingAddressDifferent.setSelected(false);
        resetmailingAddress();
        this.email.reset();
        this.phone1.reset();
        this.phone2.reset();
        this.emergencyContactName.reset();
        this.emergencyContactPhone.reset();
        this.housingTypeIndependent.setSelected(true);
        this.timesHomeless.reset();
        this.lengthRecentHomeless.reset();
        this.atRiskMovingNursing.setSelected(false);
    }

    private void resetmailingAddress() {
        mailingAddressPanel.setVisible(false);
        this.mailAddress1.reset();
        this.mailAddress2.reset();
        this.mailCity.reset();
        this.mailState.reset();
        this.mailZipCode.reset();
        this.mailCounty.reset();
    }
}
