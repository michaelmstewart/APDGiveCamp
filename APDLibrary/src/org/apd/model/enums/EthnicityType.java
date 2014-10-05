package org.apd.model.enums;

public enum EthnicityType {
    AfricanAmericanOrBlack(2),
    AmericanIndianOrAlaskaNative(5),
    Asian(1),
    Caucasian(3),
    HispanicOrLatino(4),
    OtherOrUnknown(0),
    PacificIslanderOrNativeHawaiian(6),
    TwoOrMoreRaces(7);

    private final int id;

    EthnicityType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}