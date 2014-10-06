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

    public IntakePanel() {
        this.setName("Intake Form");
        setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        this.housingInformationPanel = new HousingInformationPanel();
        this.additionalInformationPanel = new AdditionalInformationPanel();
        centerPanel.add(this.housingInformationPanel);
        centerPanel.add(this.additionalInformationPanel);
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

        String mailCounty = this.housingInformationPanel.mailCounty.getDropdown().getSelectedItem() == null ? "" : this.housingInformationPanel.mailCounty.getDropdown().getSelectedItem().toString();
        Address mailingAddr = new Address(this.housingInformationPanel.mailAddress1.getTextField().getText(),
                this.housingInformationPanel.mailAddress2.getTextField().getText(),
                this.housingInformationPanel.mailCity.getTextField().getText(),
                this.housingInformationPanel.mailState.getDropdown().getSelectedItem().toString(),
                mailCounty,
                mailZipInteger);

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

        AdditionalInformation additionalInformation = new AdditionalInformation(this.additionalInformationPanel.plan504.isSelected(),
                this.additionalInformationPanel.planIep.isSelected(),
                this.additionalInformationPanel.isRegisteredVoter.isSelected(),
                this.additionalInformationPanel.becomeRegisteredVoter.isSelected(),
                this.additionalInformationPanel.howLearnedAboutAlliance.getTextField().getText(),
                this.additionalInformationPanel.referredAgency.getTextField().getText(),
                CommFormatCode.Braille,
                this.additionalInformationPanel.accessAssistiveTechnology.isSelected(),
                this.additionalInformationPanel.accessHealthCare.isSelected(),
                this.additionalInformationPanel.accessTransportation.isSelected());

        Demographics demographics = new Demographics(new Date(), GenderType.Male, 69, false, GenderType.Female, 18, 100000.0, MaritalStatusCode.MarriedOrDomesticPartner, true, EthnicityType.AfricanAmericanOrBlack, false, true, false, StateEmploymentCode.OtherEmployment, "demographicComments", false);
        IntakeForm intake = new IntakeForm(customer, additionalInformation, demographics, "intakeComments", false);
        return intake;
    }
}
