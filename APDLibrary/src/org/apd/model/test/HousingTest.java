package org.apd.model.test;

import org.apd.model.domain.*;
import org.apd.model.enums.HousingType;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class HousingTest {
    @Test
    public void toStringTest() {
        Housing housing = new Housing();

        Assert.assertEquals("null null null null null null null", housing.toString());

        Address homeAddress = new Address("123 main street", "line2", "anytown", "PA", "york", 12345);
        Address mailingAddress = new Address("456 second street", "", "notown", "WA", "king", 98052);
        housing = new Housing(homeAddress, mailingAddress, HousingType.Independent, 2, "7 months", false);

        System.out.println(housing);
        System.out.println((new Date()).toString());
    }
}
