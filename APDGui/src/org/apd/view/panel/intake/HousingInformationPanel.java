package org.apd.view.panel.intake;

import org.apd.model.domain.County;
import org.apd.model.parsers.LocaleParser;
import org.apd.view.components.LabeledDropdown;
import org.apd.view.components.LabeledTextField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class HousingInformationPanel extends JPanel {
    static LocaleParser LocaleParser;
    private JLabel sectionInformation;
    private LabeledTextField homeAddress1;
    private LabeledTextField homeAddress2;
    private LabeledTextField homeCity;
    private LabeledDropdown homeState;
    private LabeledTextField homeZipCode;
    private LabeledDropdown homeCounty;

    private JCheckBox isMailingAddressDifferent;
    private JPanel mailingAddressPanel;
    private LabeledTextField mailAddress1;
    private LabeledTextField mailAddress2;
    private LabeledTextField mailCity;
    private LabeledDropdown mailState;
    private LabeledTextField mailZipCode;
    private LabeledDropdown mailCounty;

    private LabeledTextField email;
    private LabeledTextField phone1;
    private JRadioButton phone1HomeType;
    private JRadioButton phone1WorkType;
    private JRadioButton phone1MobileType;
    private JRadioButton phone1TTYType;
    private JRadioButton phone1FaxType;
    private LabeledTextField phone2;
    private LabeledTextField extension1;
    private LabeledTextField extension2;
    private LabeledTextField emergencyContactName;
    private LabeledTextField emergencyContactPhone;
    private ButtonGroup housingType;
    private JRadioButton housingTypeHomeless;
    private JRadioButton housingTypeInstitution;
    private JRadioButton housingTypeDependentOnFamilyOrFriends;
    private JRadioButton housingTypeAssistedLiving;
    private JRadioButton housingTypeIndependent;
    private JRadioButton housingTypeOther;
    private JRadioButton housingTypeRentSubsidized;
    private JRadioButton housingTypeRentUnsubsidized;
    private JPanel homelessPanel;
    private LabeledTextField timesHomeless;
    private LabeledTextField lengthRecentHomeless;
    private JCheckBox atRiskMovingNursing;

    public HousingInformationPanel() {
        InitializeComponents();
        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(this.getHomeAddress1());
        centerPanel.add(this.getHomeAddress2());
        centerPanel.add(this.getHomeCity());
        centerPanel.add(this.getHomeState());
        centerPanel.add(this.getHomeZipCode());
        centerPanel.add(this.getHomeCounty());
        centerPanel.add(this.getIsMailingAddressDifferent());
        centerPanel.add(this.getMailingAddressPanel());
        centerPanel.add(this.getEmail());
        centerPanel.add(this.getPhone1());
        centerPanel.add(this.getPhone2());
        centerPanel.add(this.getEmergencyContactName());
        centerPanel.add(this.getEmergencyContactPhone());

        JPanel homeTypeGridBag = new JPanel();
        centerPanel.add(new JLabel("What type of housing are you currently living in?"));
        homeTypeGridBag.setLayout(new GridLayout(3, 3));
        homeTypeGridBag.setAlignmentX(Component.LEFT_ALIGNMENT);
        homeTypeGridBag.add(this.getHousingTypeAssistedLiving());
        homeTypeGridBag.add(this.getHousingTypeDependentOnFamilyOrFriends());
        homeTypeGridBag.add(this.getHousingTypeHomeless());
        homeTypeGridBag.add(this.getHousingTypeIndependent());
        homeTypeGridBag.add(this.getHousingTypeInstitution());
        homeTypeGridBag.add(this.getHousingTypeOther());
        homeTypeGridBag.add(this.getHousingTypeRentSubsidized());
        homeTypeGridBag.add(this.getHousingTypeRentUnsubsidized());
        centerPanel.add(homeTypeGridBag);
        centerPanel.add(this.getHomelessPanel());

        centerPanel.add(this.getAtRiskMovingNursing());

        this.add(this.getSectionInformation(), BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createBevelBorder(1));
    }

    private void InitializeComponents() {
        HousingInformationPanel.LocaleParser = new LocaleParser();
        this.setSectionInformation(new JLabel("Contact/Housing Information"));
        this.setHomeAddress1(new LabeledTextField("Home Address Line 1", 20));
        this.setHomeAddress2(new LabeledTextField("Home Address Line 2", 20));
        this.setHomeCity(new LabeledTextField("Home City", 10));
        this.setHomeZipCode(new LabeledTextField("Home Zip Code", 5));

        ArrayList<String> states = new ArrayList<String>();
        for(String key : HousingInformationPanel.LocaleParser.getStatesByShortCode().keySet()) {
            states.add(key);
        }
        states.add("");
        Collections.sort(states);

        this.setHomeState(new LabeledDropdown("Home State", states.toArray()));
        this.getHomeState().getDropdown().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String state = ((JComboBox) e.getSource()).getSelectedItem().toString();
                ArrayList<String> counties = new ArrayList<String>();
                getHomeCounty().getDropdown().removeAllItems();
                getHomeCounty().getDropdown().setPreferredSize(null);
                for (County county : HousingInformationPanel.LocaleParser.getCountiesSetByState().get(state)) {
                    counties.add(county.getName());
                }
                Collections.sort(counties);
                String longestString = "";
                for (String s : counties) {
                    getHomeCounty().getDropdown().addItem(s);
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

        this.setHomeCounty(new LabeledDropdown("Home County", new String[]{"starting string"}));
        this.getHomeState().getDropdown().setSelectedItem("WA");
        this.getHomeCounty().getDropdown().setSelectedItem("King");

        this.setIsMailingAddressDifferent(new JCheckBox("Is Mailing Address Different?"));
        this.getIsMailingAddressDifferent().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox box = (JCheckBox) e.getSource();
                if (box.isSelected()) {
                    getMailingAddressPanel().setVisible(true);
                } else {
                    resetmailingAddress();
                }
            }
        });

        setMailingAddressPanel(new JPanel());
        getMailingAddressPanel().setLayout(new BoxLayout(getMailingAddressPanel(), BoxLayout.PAGE_AXIS));
        this.setMailAddress1(new LabeledTextField("Mailing Address Line 1", 20));
        this.setMailAddress2(new LabeledTextField("Mailing Address Line 2", 20));
        this.setMailCity(new LabeledTextField("Mailing City", 10));
        this.setMailZipCode(new LabeledTextField("Mailing Zip Code", 5));

        ArrayList<String> mailStates = new ArrayList<String>();
        for(String key : HousingInformationPanel.LocaleParser.getStatesByShortCode().keySet()) {
            mailStates.add(key);
        }
        mailStates.add("");
        Collections.sort(mailStates);

        this.setMailState(new LabeledDropdown("Mailing State", mailStates.toArray()));
        this.getMailState().getDropdown().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String state = ((JComboBox) e.getSource()).getSelectedItem().toString();
                if(state != null && !state.equals("")) {
                    ArrayList<String> counties = new ArrayList<String>();
                    getMailCounty().getDropdown().removeAllItems();
                    getMailCounty().getDropdown().setPreferredSize(null);
                    for (County county : HousingInformationPanel.LocaleParser.getCountiesSetByState().get(state)) {
                        counties.add(county.getName());
                    }
                    Collections.sort(counties);
                    String longestString = "";
                    for (String s : counties) {
                        getMailCounty().getDropdown().addItem(s);
                        if (s.length() > longestString.length()) {
                            longestString = s;
                        }
                    }
                }
            }
        });

        this.setMailCounty(new LabeledDropdown("Mailing County", new String[]{"          "}));
        getMailingAddressPanel().add(this.getMailAddress1());
        getMailingAddressPanel().add(this.getMailAddress2());
        getMailingAddressPanel().add(this.getMailCity());
        getMailingAddressPanel().add(this.getMailState());
        getMailingAddressPanel().add(this.getMailZipCode());
        getMailingAddressPanel().add(this.getMailCounty());
        getMailingAddressPanel().setVisible(false);

        this.setEmail(new LabeledTextField("Email address", 20));
        this.setPhone1(new LabeledTextField("Home", 10));
        this.setPhone2(new LabeledTextField("Mobile Phone", 10));
        this.setEmergencyContactName(new LabeledTextField("Emergency contact full name", 20));
        this.setEmergencyContactPhone(new LabeledTextField("Emergency contact phone number", 20));

        this.setHousingType(new ButtonGroup());
        this.setHousingTypeHomeless(new JRadioButton("Homeless"));
        this.setHousingTypeInstitution(new JRadioButton("Institution"));
        this.setHousingTypeDependentOnFamilyOrFriends(new JRadioButton("Dependent on Family/Friends"));
        this.setHousingTypeAssistedLiving(new JRadioButton("Assisted Living"));
        this.setHousingTypeIndependent(new JRadioButton("Independent"));
        this.getHousingTypeIndependent().setSelected(true);
        this.setHousingTypeOther(new JRadioButton("Other"));
        this.setHousingTypeRentSubsidized(new JRadioButton("Rent - Subsidized"));
        this.setHousingTypeRentUnsubsidized(new JRadioButton("Rent - Unsubsidized"));
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
        this.setHomelessPanel(new JPanel());
        this.getHomelessPanel().setLayout(new BoxLayout(this.getHomelessPanel(), BoxLayout.PAGE_AXIS));
        this.setTimesHomeless(new LabeledTextField("How many times have you been homeless in the past three years?", 5));
        this.setLengthRecentHomeless(new LabeledTextField("How long have you been homeless this last time?", 10));
        this.getHomelessPanel().add(this.getTimesHomeless());
        this.getHomelessPanel().add(this.getLengthRecentHomeless());

        this.getHousingType().add(this.getHousingTypeAssistedLiving());
        this.getHousingType().add(this.getHousingTypeDependentOnFamilyOrFriends());
        this.getHousingType().add(this.getHousingTypeHomeless());
        this.getHousingType().add(this.getHousingTypeIndependent());
        this.getHousingType().add(this.getHousingTypeInstitution());
        this.getHousingType().add(this.getHousingTypeOther());
        this.getHousingType().add(this.getHousingTypeRentSubsidized());
        this.getHousingType().add(this.getHousingTypeRentUnsubsidized());
        //this.homelessPanel.setVisible(false);

        this.setAtRiskMovingNursing(new JCheckBox("Do you feel you are at risk for moving into a nursing facility?"));
        // Set Alignments
        this.getSectionInformation().setHorizontalAlignment(JLabel.CENTER);
        this.getSectionInformation().setVerticalAlignment(JLabel.CENTER);
    }

    public void Reset() {
        this.getHomeAddress1().reset();
        this.getHomeAddress2().reset();
        this.getHomeCity().reset();
        this.getHomeState().getDropdown().setSelectedItem("WA");
        this.getHomeZipCode().reset();
        this.getHomeCounty().getDropdown().setSelectedItem("King");
        this.getIsMailingAddressDifferent().setSelected(false);
        resetmailingAddress();
        this.getEmail().reset();
        this.getPhone1().reset();
        this.getPhone2().reset();
        this.getEmergencyContactName().reset();
        this.getEmergencyContactPhone().reset();
        this.getHousingTypeIndependent().setSelected(true);
        this.getTimesHomeless().reset();
        this.getLengthRecentHomeless().reset();
        this.getAtRiskMovingNursing().setSelected(false);
    }

    private void resetmailingAddress() {
        getMailingAddressPanel().setVisible(false);
        this.getMailAddress1().reset();
        this.getMailAddress2().reset();
        this.getMailCity().reset();
        this.getMailState().reset();
        this.getMailZipCode().reset();
        this.getMailCounty().reset();
    }

    public JLabel getSectionInformation() {
        return sectionInformation;
    }

    public void setSectionInformation(JLabel sectionInformation) {
        this.sectionInformation = sectionInformation;
    }

    public LabeledTextField getHomeAddress1() {
        return homeAddress1;
    }

    public void setHomeAddress1(LabeledTextField homeAddress1) {
        this.homeAddress1 = homeAddress1;
    }

    public LabeledTextField getHomeAddress2() {
        return homeAddress2;
    }

    public void setHomeAddress2(LabeledTextField homeAddress2) {
        this.homeAddress2 = homeAddress2;
    }

    public LabeledTextField getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(LabeledTextField homeCity) {
        this.homeCity = homeCity;
    }

    public LabeledDropdown getHomeState() {
        return homeState;
    }

    public void setHomeState(LabeledDropdown homeState) {
        this.homeState = homeState;
    }

    public LabeledTextField getHomeZipCode() {
        return homeZipCode;
    }

    public void setHomeZipCode(LabeledTextField homeZipCode) {
        this.homeZipCode = homeZipCode;
    }

    public LabeledDropdown getHomeCounty() {
        return homeCounty;
    }

    public void setHomeCounty(LabeledDropdown homeCounty) {
        this.homeCounty = homeCounty;
    }

    public JCheckBox getIsMailingAddressDifferent() {
        return isMailingAddressDifferent;
    }

    public void setIsMailingAddressDifferent(JCheckBox isMailingAddressDifferent) {
        this.isMailingAddressDifferent = isMailingAddressDifferent;
    }

    public JPanel getMailingAddressPanel() {
        return mailingAddressPanel;
    }

    public void setMailingAddressPanel(JPanel mailingAddressPanel) {
        this.mailingAddressPanel = mailingAddressPanel;
    }

    public LabeledTextField getMailAddress1() {
        return mailAddress1;
    }

    public void setMailAddress1(LabeledTextField mailAddress1) {
        this.mailAddress1 = mailAddress1;
    }

    public LabeledTextField getMailAddress2() {
        return mailAddress2;
    }

    public void setMailAddress2(LabeledTextField mailAddress2) {
        this.mailAddress2 = mailAddress2;
    }

    public LabeledTextField getMailCity() {
        return mailCity;
    }

    public void setMailCity(LabeledTextField mailCity) {
        this.mailCity = mailCity;
    }

    public LabeledDropdown getMailState() {
        return mailState;
    }

    public void setMailState(LabeledDropdown mailState) {
        this.mailState = mailState;
    }

    public LabeledTextField getMailZipCode() {
        return mailZipCode;
    }

    public void setMailZipCode(LabeledTextField mailZipCode) {
        this.mailZipCode = mailZipCode;
    }

    public LabeledDropdown getMailCounty() {
        return mailCounty;
    }

    public void setMailCounty(LabeledDropdown mailCounty) {
        this.mailCounty = mailCounty;
    }

    public LabeledTextField getEmail() {
        return email;
    }

    public void setEmail(LabeledTextField email) {
        this.email = email;
    }

    public LabeledTextField getPhone1() {
        return phone1;
    }

    public void setPhone1(LabeledTextField phone1) {
        this.phone1 = phone1;
    }

    public JRadioButton getPhone1HomeType() {
        return phone1HomeType;
    }

    public void setPhone1HomeType(JRadioButton phone1HomeType) {
        this.phone1HomeType = phone1HomeType;
    }

    public JRadioButton getPhone1WorkType() {
        return phone1WorkType;
    }

    public void setPhone1WorkType(JRadioButton phone1WorkType) {
        this.phone1WorkType = phone1WorkType;
    }

    public JRadioButton getPhone1MobileType() {
        return phone1MobileType;
    }

    public void setPhone1MobileType(JRadioButton phone1MobileType) {
        this.phone1MobileType = phone1MobileType;
    }

    public JRadioButton getPhone1TTYType() {
        return phone1TTYType;
    }

    public void setPhone1TTYType(JRadioButton phone1TTYType) {
        this.phone1TTYType = phone1TTYType;
    }

    public JRadioButton getPhone1FaxType() {
        return phone1FaxType;
    }

    public void setPhone1FaxType(JRadioButton phone1FaxType) {
        this.phone1FaxType = phone1FaxType;
    }

    public LabeledTextField getPhone2() {
        return phone2;
    }

    public void setPhone2(LabeledTextField phone2) {
        this.phone2 = phone2;
    }

    public LabeledTextField getExtension1() {
        return extension1;
    }

    public void setExtension1(LabeledTextField extension1) {
        this.extension1 = extension1;
    }

    public LabeledTextField getExtension2() {
        return extension2;
    }

    public void setExtension2(LabeledTextField extension2) {
        this.extension2 = extension2;
    }

    public LabeledTextField getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(LabeledTextField emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public LabeledTextField getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    public void setEmergencyContactPhone(LabeledTextField emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public ButtonGroup getHousingType() {
        return housingType;
    }

    public void setHousingType(ButtonGroup housingType) {
        this.housingType = housingType;
    }

    public JRadioButton getHousingTypeHomeless() {
        return housingTypeHomeless;
    }

    public void setHousingTypeHomeless(JRadioButton housingTypeHomeless) {
        this.housingTypeHomeless = housingTypeHomeless;
    }

    public JRadioButton getHousingTypeInstitution() {
        return housingTypeInstitution;
    }

    public void setHousingTypeInstitution(JRadioButton housingTypeInstitution) {
        this.housingTypeInstitution = housingTypeInstitution;
    }

    public JRadioButton getHousingTypeDependentOnFamilyOrFriends() {
        return housingTypeDependentOnFamilyOrFriends;
    }

    public void setHousingTypeDependentOnFamilyOrFriends(JRadioButton housingTypeDependentOnFamilyOrFriends) {
        this.housingTypeDependentOnFamilyOrFriends = housingTypeDependentOnFamilyOrFriends;
    }

    public JRadioButton getHousingTypeAssistedLiving() {
        return housingTypeAssistedLiving;
    }

    public void setHousingTypeAssistedLiving(JRadioButton housingTypeAssistedLiving) {
        this.housingTypeAssistedLiving = housingTypeAssistedLiving;
    }

    public JRadioButton getHousingTypeIndependent() {
        return housingTypeIndependent;
    }

    public void setHousingTypeIndependent(JRadioButton housingTypeIndependent) {
        this.housingTypeIndependent = housingTypeIndependent;
    }

    public JRadioButton getHousingTypeOther() {
        return housingTypeOther;
    }

    public void setHousingTypeOther(JRadioButton housingTypeOther) {
        this.housingTypeOther = housingTypeOther;
    }

    public JRadioButton getHousingTypeRentSubsidized() {
        return housingTypeRentSubsidized;
    }

    public void setHousingTypeRentSubsidized(JRadioButton housingTypeRentSubsidized) {
        this.housingTypeRentSubsidized = housingTypeRentSubsidized;
    }

    public JRadioButton getHousingTypeRentUnsubsidized() {
        return housingTypeRentUnsubsidized;
    }

    public void setHousingTypeRentUnsubsidized(JRadioButton housingTypeRentUnsubsidized) {
        this.housingTypeRentUnsubsidized = housingTypeRentUnsubsidized;
    }

    public JPanel getHomelessPanel() {
        return homelessPanel;
    }

    public void setHomelessPanel(JPanel homelessPanel) {
        this.homelessPanel = homelessPanel;
    }

    public LabeledTextField getTimesHomeless() {
        return timesHomeless;
    }

    public void setTimesHomeless(LabeledTextField timesHomeless) {
        this.timesHomeless = timesHomeless;
    }

    public LabeledTextField getLengthRecentHomeless() {
        return lengthRecentHomeless;
    }

    public void setLengthRecentHomeless(LabeledTextField lengthRecentHomeless) {
        this.lengthRecentHomeless = lengthRecentHomeless;
    }

    public JCheckBox getAtRiskMovingNursing() {
        return atRiskMovingNursing;
    }

    public void setAtRiskMovingNursing(JCheckBox atRiskMovingNursing) {
        this.atRiskMovingNursing = atRiskMovingNursing;
    }
}
