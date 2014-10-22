package org.apd.view.panel;

import org.apd.model.domain.*;
import org.apd.model.enums.*;
import org.apd.view.components.LabeledTextField;
import org.apd.view.panel.intake.AdditionalInformationPanel;
import org.apd.view.panel.intake.DemographicInformationPanel;
import org.apd.view.panel.intake.HousingInformationPanel;
import org.apd.view.panel.intake.MiscellaneousPanel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IntakePanel extends JComponent {
    LabeledTextField name;
    LabeledTextField date;
    protected SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/YYYY");

    HousingInformationPanel housingInformationPanel;
    AdditionalInformationPanel additionalInformationPanel;
    DemographicInformationPanel demographicInformationPanel;
    MiscellaneousPanel miscellaneousPanel;

    public IntakePanel() {
        this.setName("Intake Form");
        setLayout(new BorderLayout());
        ScrollablePanel centerPanel = new ScrollablePanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.setAlignmentX(0);
        this.housingInformationPanel = new HousingInformationPanel();
        this.additionalInformationPanel = new AdditionalInformationPanel();
        this.demographicInformationPanel = new DemographicInformationPanel();
        this.miscellaneousPanel = new MiscellaneousPanel();
        centerPanel.add(this.housingInformationPanel);
        centerPanel.add(this.additionalInformationPanel);
        centerPanel.add(this.demographicInformationPanel);
        centerPanel.add(this.miscellaneousPanel);
        JScrollPane scrollPane = new JScrollPane(centerPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        this.name = new LabeledTextField("Name", 20);
        this.date = new LabeledTextField("Date", 10);
        this.date.getTextField().setText(dateFormat.format(new Date()));

        topPanel.add(this.name, BorderLayout.WEST);
        topPanel.add(this.date, BorderLayout.EAST);

        this.add(topPanel, BorderLayout.NORTH);
    }

    public IntakeForm OnSubmit() {
        String[] nameparts = this.name.getTextField().getText().split(" ");
        String lastname = nameparts[nameparts.length - 1];
        String firstname = "";
        for (int i = 0; i < nameparts.length - 1; i++) {
            firstname += nameparts[i] + " ";
        }
        firstname = firstname.trim();
        String homeZip = this.housingInformationPanel.getHomeZipCode().getTextField().getText();
        Integer homeZipInteger = null;
        if (homeZip != null && !homeZip.equals("")) {
            homeZipInteger = Integer.parseInt(homeZip);
        }
        Address homeAddr = new Address(this.housingInformationPanel.getHomeAddress1().getTextField().getText(),
                this.housingInformationPanel.getHomeAddress2().getTextField().getText(),
                this.housingInformationPanel.getHomeCity().getTextField().getText(),
                this.housingInformationPanel.getHomeState().getDropdown().getSelectedItem().toString(),
                this.housingInformationPanel.getHomeCounty().getDropdown().getSelectedItem().toString(),
                homeZipInteger);

        Address mailingAddr;
        if(this.housingInformationPanel.getIsMailingAddressDifferent().isSelected()) {
            String mailCounty = this.housingInformationPanel.getMailCounty().getDropdown().getSelectedItem() == null ? "" : this.housingInformationPanel.getMailCounty().getDropdown().getSelectedItem().toString();
            String mailZip = this.housingInformationPanel.getMailZipCode().getTextField().getText();
            Integer mailZipInteger = null;
            if (mailZip != null && !mailZip.equals("")) {
                mailZipInteger = Integer.parseInt(mailZip);
            }

            mailingAddr = new Address(this.housingInformationPanel.getMailAddress1().getTextField().getText(),
                    this.housingInformationPanel.getMailAddress2().getTextField().getText(),
                    this.housingInformationPanel.getMailCity().getTextField().getText(),
                    this.housingInformationPanel.getMailState().getDropdown().getSelectedItem().toString(),
                    mailCounty,
                    mailZipInteger);
        } else {
            mailingAddr = new Address();
        }

        Integer numTimesHomeless = null;
        if (!this.housingInformationPanel.getTimesHomeless().getTextField().getText().equals("")) {
            numTimesHomeless = Integer.parseInt(this.housingInformationPanel.getTimesHomeless().getTextField().getText());
        }

        HousingType housingType = null;
        if (this.housingInformationPanel.getHousingTypeAssistedLiving().isSelected()) {
            housingType = HousingType.AssistedLiving;
        } else if (this.housingInformationPanel.getHousingTypeDependentOnFamilyOrFriends().isSelected()) {
            housingType = HousingType.DependentOnFamilyOrFriends;
        } else if (this.housingInformationPanel.getHousingTypeHomeless().isSelected()) {
            housingType = HousingType.Homeless;
        } else if (this.housingInformationPanel.getHousingTypeIndependent().isSelected()) {
            housingType = HousingType.Independent;
        } else if (this.housingInformationPanel.getHousingTypeInstitution().isSelected()) {
            housingType = HousingType.Institution;
        } else if (this.housingInformationPanel.getHousingTypeOther().isSelected()) {
            housingType = HousingType.Other;
        } else if (this.housingInformationPanel.getHousingTypeRentSubsidized().isSelected()) {
            housingType = HousingType.RentSubsidized;
        } else if (this.housingInformationPanel.getHousingTypeRentUnsubsidized().isSelected()) {
            housingType = HousingType.RentUnsubsidized;
        }

        Housing housing = new Housing(homeAddr,
                mailingAddr,
                housingType,
                numTimesHomeless,
                this.housingInformationPanel.getLengthRecentHomeless().getTextField().getText(),
                this.housingInformationPanel.getAtRiskMovingNursing().isSelected());

        Customer customer = new Customer(firstname,
                lastname,
                housing,
                this.housingInformationPanel.getEmail().getTextField().getText(),
                new PhoneNumber(this.housingInformationPanel.getPhone1().getTextField().getText()),
                new PhoneNumber(this.housingInformationPanel.getPhone2().getTextField().getText(), "", PhoneType.Mobile),
                this.housingInformationPanel.getEmergencyContactName().getTextField().getText(),
                this.housingInformationPanel.getEmergencyContactPhone().getTextField().getText(),
                new Date(this.date.getTextField().getText()));

        CommFormatCode alternateFormat = null;
        switch(this.additionalInformationPanel.getAlternateFormats().getDropdown().getSelectedIndex()) {
            case 0:
                alternateFormat = CommFormatCode.None;
                break;
            case 1:
                alternateFormat = CommFormatCode.Standard;
                break;
            case 2:
                alternateFormat = CommFormatCode.LargePrint;
                break;
            case 3:
                alternateFormat = CommFormatCode.Braille;
                break;
            case 4:
                alternateFormat = CommFormatCode.AudioTape;
                break;
            case 5:
                alternateFormat = CommFormatCode.CD;
                break;
            case 6:
                alternateFormat = CommFormatCode.EmailStandard;
                break;
            case 7:
                alternateFormat = CommFormatCode.EmailLargePrint;
                break;
        }

        AdditionalInformation additionalInformation = new AdditionalInformation(this.additionalInformationPanel.getPlan504().isSelected(),
                this.additionalInformationPanel.getPlanIep().isSelected(),
                this.additionalInformationPanel.getIsRegisteredVoter().isSelected(),
                this.additionalInformationPanel.getBecomeRegisteredVoter().isSelected(),
                this.additionalInformationPanel.getHowLearnedAboutAlliance().getTextField().getText(),
                this.additionalInformationPanel.getReferredAgency().getTextField().getText(),
                alternateFormat,
                this.additionalInformationPanel.getAccessAssistiveTechnology().isSelected(),
                this.additionalInformationPanel.getAccessHealthCare().isSelected(),
                this.additionalInformationPanel.getAccessHealthCare().isSelected());
        
        GenderType gender = null;
        switch (this.demographicInformationPanel.getGender().getDropdown().getSelectedIndex()) {
            case 1:
                gender = GenderType.Male;
                break;
            case 2:
                gender = GenderType.Female;
                break;
            case 3:
                gender = GenderType.Unknown;
                break;
        }
        
        GenderType householdGender = null;
        switch (this.demographicInformationPanel.getHeadOfHouseGender().getDropdown().getSelectedIndex()) {
            case 0:
                householdGender = GenderType.Male;
                break;
            case 1:
                householdGender = GenderType.Female;
                break;
            case 2:
                householdGender = GenderType.Unknown;
                break;
        }
        
        Double grossIncome = null;
        String grossIncomeText = this.demographicInformationPanel.getGrossMonthlyIncome().getTextField().getText();
        if(!grossIncomeText.equals("")) {
            if(grossIncomeText.trim().startsWith("$")) {
                grossIncomeText = grossIncomeText.trim().substring(1);
            }
            
            if(grossIncomeText.trim().endsWith("$")) {
                grossIncomeText = grossIncomeText.trim().substring(0, grossIncomeText.trim().length() -1);
            }
            
            grossIncome = Double.parseDouble(grossIncomeText);
        }
        
        MaritalStatusCode maritalStatus = null;
        switch (this.demographicInformationPanel.getMaritalStatus().getDropdown().getSelectedIndex()) {
            case 0:
                maritalStatus = MaritalStatusCode.Single;
                break;
            case 1:
                maritalStatus = MaritalStatusCode.MarriedOrDomesticPartner;
                break;
            case 2:
                maritalStatus = MaritalStatusCode.Separated;
                break;
            case 3:
                maritalStatus = MaritalStatusCode.Divorced;
                break;
            case 4:
                maritalStatus = MaritalStatusCode.Widowed;
                break;
        }

        EthnicityType ethnicity = null;
        switch(this.demographicInformationPanel.getEthnicity().getDropdown().getSelectedIndex()) {
            case 0:
                ethnicity = EthnicityType.AfricanAmericanOrBlack;
                break;
            case 1:
                ethnicity = EthnicityType.AmericanIndianOrAlaskaNative;
                break;
            case 2:
                ethnicity = EthnicityType.Asian;
                break;
            case 3:
                ethnicity = EthnicityType.Caucasian;
                break;
            case 4:
                ethnicity = EthnicityType.HispanicOrLatino;
                break;
            case 5:
                ethnicity = EthnicityType.PacificIslanderOrNativeHawaiian;
                break;
            case 6:
                ethnicity = EthnicityType.TwoOrMoreRaces;
                break;
            case 7:
                ethnicity = EthnicityType.OtherOrUnknown;
                break;
        }

        StateEmploymentCode employmentCode = null;
        switch (this.demographicInformationPanel.getWorkStatus().getDropdown().getSelectedIndex()) {
            case 0:
                employmentCode = StateEmploymentCode.FullTime;
                break;
            case 1:
                employmentCode = StateEmploymentCode.PartTime;
                break;
            case 2:
                employmentCode = StateEmploymentCode.LookingForAJob;
                break;
            case 3:
                employmentCode = StateEmploymentCode.StudentOrInAProgram;
                break;
            case 4:
                employmentCode = StateEmploymentCode.Retired;
                break;
            case 5:
                employmentCode = StateEmploymentCode.ParticipatingInSegregatedWorkOrDayProgram;
                break;
            case 6:
                employmentCode = StateEmploymentCode.Unknown;
                break;
            case 7:
                employmentCode = StateEmploymentCode.OtherEmployment;
                break;
        }

        int numHousehold;
        try {
            numHousehold = Integer.parseInt(this.demographicInformationPanel.getNumPeopleLivingInHousehold().getTextField().getText());
        } catch (Exception e) {
            numHousehold = 1;
        }

        int numUnder18;
        try {
            numUnder18 = Integer.parseInt(this.demographicInformationPanel.getNumChildrenUnder18().getTextField().getText());
        } catch (Exception e) {
            numUnder18 = 0;
        }

        Demographics demographics = new Demographics(new Date(this.demographicInformationPanel.getBirthdate().getTextField().getText()),
                gender,
                numHousehold,
                this.demographicInformationPanel.getSingleParentHousehold().isSelected(),
                householdGender,
                numUnder18,
                grossIncome,
                maritalStatus,
                this.demographicInformationPanel.getLatino().isSelected(),
                ethnicity,
                this.demographicInformationPanel.getLimitedEnglish().isSelected(),
                this.demographicInformationPanel.getImmigrant().isSelected(),
                this.demographicInformationPanel.getEmployed().isSelected(),
                employmentCode,
                this.demographicInformationPanel.getDemographicComments().getTextField().getText(),
                this.demographicInformationPanel.getMilitary().isSelected());
        
        IntakeForm intake = new IntakeForm(customer,
                additionalInformation,
                demographics,
                this.miscellaneousPanel.getAdditionalComments().getTextField().getText(),
                this.miscellaneousPanel.getOptout().isSelected());

        return intake;
    }

    public void Reset() {
        this.name.reset();
        this.housingInformationPanel.Reset();
        this.additionalInformationPanel.Reset();
        this.demographicInformationPanel.Reset();
        this.miscellaneousPanel.Reset();
    }
}
