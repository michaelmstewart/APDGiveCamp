package org.apd.model.test;

import org.apd.model.domain.Demographics;
import org.apd.model.enums.EthnicityType;
import org.apd.model.enums.GenderType;
import org.apd.model.enums.MaritalStatusCode;
import org.apd.model.enums.StateEmploymentCode;
import org.junit.Test;

import java.util.Calendar;

public class DemographicsTest {
    @Test
    public void demographicsCsvTest() {
        Demographics d = new Demographics();
        System.out.println(d.toCsv());

        Calendar c = Calendar.getInstance();
        c.set(1988, Calendar.JULY, 26);

        d = new Demographics(c.getTime(), GenderType.Male, 2, true, GenderType.Female, 0, 100000.0,
                MaritalStatusCode.Single, false, EthnicityType.Caucasian, false,
                true, true, StateEmploymentCode.FullTime, "some, comments", false);
        System.out.println(d.toCsv());
    }
}
