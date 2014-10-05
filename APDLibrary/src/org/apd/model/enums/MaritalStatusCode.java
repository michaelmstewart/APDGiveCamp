package org.apd.model.enums;

public enum MaritalStatusCode {

    Single(1),
    MarriedOrDomesticPartner(2),
    Separated(3),
    Divorced(4),
    Widowed(5);

    private final int id;

    MaritalStatusCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}