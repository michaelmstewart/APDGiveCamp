package org.apd.model.test;

import org.apd.model.domain.*;
import org.apd.model.enums.*;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class CustomerTest {
    @Test
    public void customerTest() {
        Customer c = new Customer("first", "last");
        System.out.println(c.toCsv());

        Calendar cal = Calendar.getInstance();
        cal.set(1988, Calendar.JULY, 26);

        Demographics d = new Demographics(cal.getTime(), GenderType.Male, 2, true, GenderType.Female, 0, 100000.0,
                MaritalStatusCode.MarriedOrDomesticPartner, false, EthnicityType.Caucasian, false,
                true, true, StateEmploymentCode.FullTime, "some, comments", false);
        Address addr = new Address("2718 Heather Drive", null, "York", "PA", "York", 17402);
        Housing h = new Housing(addr, null, null, null, null, null);
        c = new Customer("first", // String
                "last",       // String
                h,          //  Housing
                "a@a.com",      // String
                new PhoneNumber("1235555555"),      // PhoneNumber
                new PhoneNumber("5551234567", "", PhoneType.Mobile),     // PhoneNumber
                null,null,
                new Date());       // Date
        System.out.println(c.toCsv());
    }
}
