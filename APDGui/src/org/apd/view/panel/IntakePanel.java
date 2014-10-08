package org.apd.view.panel;

import org.apd.model.domain.*;
import org.apd.model.enums.*;
import org.apd.view.components.LabeledTextField;

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
        String homeZip = this.housingInformationPanel.homeZipCode.getTextField().getText();
        Integer homeZipInteger = null;
        if (homeZip != null && !homeZip.equals("")) {
            homeZipInteger = Integer.parseInt(homeZip);
        }
        Address homeAddr = new Address(this.housingInformationPanel.homeAddress1.getTextField().getText(),
                this.housingInformationPanel.homeAddress2.getTextField().getText(),
                this.housingInformationPanel.homeCity.getTextField().getText(),
                this.housingInformationPanel.homeState.getDropdown().getSelectedItem().toString(),
                this.housingInformationPanel.homeCounty.getDropdown().getSelectedItem().toString(),
                homeZipInteger);

        String mailZip = this.housingInformationPanel.mailZipCode.getTextField().getText();
        Integer mailZipInteger = null;
        if (mailZip != null && !mailZip.equals("")) {
            mailZipInteger = Integer.parseInt(mailZip);
        }

        Address mailingAddr;
        if(this.housingInformationPanel.isMailingAddressDifferent.isSelected()) {
            String mailCounty = this.housingInformationPanel.mailCounty.getDropdown().getSelectedItem() == null ? "" : this.housingInformationPanel.mailCounty.getDropdown().getSelectedItem().toString();
            mailingAddr = new Address(this.housingInformationPanel.mailAddress1.getTextField().getText(),
                    this.housingInformationPanel.mailAddress2.getTextField().getText(),
                    this.housingInformationPanel.mailCity.getTextField().getText(),
                    this.housingInformationPanel.mailState.getDropdown().getSelectedItem().toString(),
                    mailCounty,
                    mailZipInteger);
        } else {
            mailingAddr = new Address();
        }

        Integer numTimesHomeless = null;
        if (!this.housingInformationPanel.timesHomeless.getTextField().getText().equals("")) {
            numTimesHomeless = Integer.parseInt(this.housingInformationPanel.timesHomeless.getTextField().getText());
        }

        HousingType housingType = null;
        if (this.housingInformationPanel.housingTypeAssistedLiving.isSelected()) {
            housingType = HousingType.AssistedLiving;
        } else if (this.housingInformationPanel.housingTypeDependentOnFamilyOrFriends.isSelected()) {
            housingType = HousingType.DependentOnFamilyOrFriends;
        } else if (this.housingInformationPanel.housingTypeHomeless.isSelected()) {
            housingType = HousingType.Homeless;
        } else if (this.housingInformationPanel.housingTypeIndependent.isSelected()) {
            housingType = HousingType.Independent;
        } else if (this.housingInformationPanel.housingTypeInstitution.isSelected()) {
            housingType = HousingType.Institution;
        } else if (this.housingInformationPanel.housingTypeOther.isSelected()) {
            housingType = HousingType.Other;
        } else if (this.housingInformationPanel.housingTypeRentSubsidized.isSelected()) {
            housingType = HousingType.RentSubsidized;
        } else if (this.housingInformationPanel.housingTypeRentUnsubsidized.isSelected()) {
            housingType = HousingType.RentUnsubsidized;
        }

        Housing housing = new Housing(homeAddr,
                mailingAddr,
                housingType,
                numTimesHomeless,
                this.housingInformationPanel.lengthRecentHomeless.getTextField().getText(),
                this.housingInformationPanel.atRiskMovingNursing.isSelected());

        Customer customer = new Customer(firstname,
                lastname,
                housing,
                this.housingInformationPanel.email.getTextField().getText(),
                new PhoneNumber(this.housingInformationPanel.phone1.getTextField().getText()),
                new PhoneNumber(this.housingInformationPanel.phone2.getTextField().getText(), "", PhoneType.Mobile),
                this.housingInformationPanel.emergencyContactName.getTextField().getText(),
                this.housingInformationPanel.emergencyContactPhone.getTextField().getText(),
                new Date(this.date.getTextField().getText()));

        CommFormatCode alternateFormat = null;
        switch(this.additionalInformationPanel.alternateFormats.getDropdown().getSelectedIndex()) {
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

        AdditionalInformation additionalInformation = new AdditionalInformation(this.additionalInformationPanel.plan504.isSelected(),
                this.additionalInformationPanel.planIep.isSelected(),
                this.additionalInformationPanel.isRegisteredVoter.isSelected(),
                this.additionalInformationPanel.becomeRegisteredVoter.isSelected(),
                this.additionalInformationPanel.howLearnedAboutAlliance.getTextField().getText(),
                this.additionalInformationPanel.referredAgency.getTextField().getText(),
                alternateFormat,
                this.additionalInformationPanel.accessAssistiveTechnology.isSelected(),
                this.additionalInformationPanel.accessHealthCare.isSelected(),
                this.additionalInformationPanel.accessTransportation.isSelected());
        
        GenderType gender = null;
        switch (this.demographicInformationPanel.gender.getDropdown().getSelectedIndex()) {
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
        switch (this.demographicInformationPanel.headOfHouseGender.getDropdown().getSelectedIndex()) {
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
        String grossIncomeText = this.demographicInformationPanel.grossMonthlyIncome.getTextField().getText();
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
        switch (this.demographicInformationPanel.maritalStatus.getDropdown().getSelectedIndex()) {
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
        switch(this.demographicInformationPanel.ethnicity.getDropdown().getSelectedIndex()) {
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
        switch (this.demographicInformationPanel.workStatus.getDropdown().getSelectedIndex()) {
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

        Demographics demographics = new Demographics(new Date(this.demographicInformationPanel.birthdate.getTextField().getText()),
                gender,
                Integer.parseInt(this.demographicInformationPanel.numPeopleLivingInHousehold.getTextField().getText()),
                this.demographicInformationPanel.singleParentHousehold.isSelected(),
                householdGender,
                Integer.parseInt(this.demographicInformationPanel.numChildrenUnder18.getTextField().getText()),
                grossIncome,
                maritalStatus,
                this.demographicInformationPanel.latino.isSelected(),
                ethnicity,
                this.demographicInformationPanel.limitedEnglish.isSelected(),
                this.demographicInformationPanel.immigrant.isSelected(),
                this.demographicInformationPanel.employed.isSelected(),
                employmentCode,
                this.demographicInformationPanel.demographicComments.getTextField().getText(),
                this.demographicInformationPanel.military.isSelected());
        
        IntakeForm intake = new IntakeForm(customer,
                additionalInformation,
                demographics,
                this.miscellaneousPanel.additionalComments.getTextField().getText(),
                this.miscellaneousPanel.optout.isSelected());

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
