package org.apd.model.test;

import org.apd.model.domain.Address;
import org.junit.Test;

public class AddressTest {
    @Test
    public void addressTest() {
        Address a = new Address();
        System.out.println(a.toCsv());
    }
}
