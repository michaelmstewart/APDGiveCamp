package org.apd.model.test;

import org.apd.model.domain.*;
import org.apd.model.enums.*;
import org.junit.Test;

import java.util.Date;

public class IntakeFormTest {
    @Test
    public void intakeFormTest() {
        Address homeAddr = new Address("homeAddrLine1", "homeAddrLine2", "homeCity", "WA", "King", 98052);
        Address mailingAddr = new Address("mailAddrLine1", "mailAddrLine2", "mailCity", "PA", "York", 17402);
        Housing housing = new Housing(homeAddr, mailingAddr, HousingType.Independent, 1, "lengthHomeless", false);
        Customer customer = new Customer("firstName", "lastName", housing,"email", new PhoneNumber("homePhone"), new PhoneNumber("mobilePhone", "", PhoneType.Mobile), new Date());

        AdditionalInformation additionalInformation = new AdditionalInformation(true, false, true, false, "howLearnedAboutAlliance", "referredFromAgency", CommFormatCode.Braille, true, false, true);
        Demographics demographics = new Demographics(new Date(), GenderType.Male, 69, false, GenderType.Female, 18, 100000.0, MaritalStatusCode.MarriedOrDomesticPartner, true, EthnicityType.AfricanAmericanOrBlack, false, true, false, StateEmploymentCode.OtherEmployment, "demographicComments", false);
        IntakeForm intake = new IntakeForm(customer, additionalInformation, demographics, "intakeComments", false);

        EligibilityForm eligibility = new EligibilityForm(LivingServicesType.APDWestKing, customer, SSADisabilityCode.BlindOrVisualImpairment, null, "eligibilityAdditionalComments", false, false, false, false, false, false, "limitedOther", true, new Date(), false, new Date());
        System.out.println(intake.toCsv() + "," + eligibility.toCsv());
    }
}
