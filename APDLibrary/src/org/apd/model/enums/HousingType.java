package org.apd.model.enums;

public enum HousingType {

    Homeless(1),
    Institution(2),
    DependentOnFamilyOrFriends(3),
    AssistedLiving(4),
    Independent(5),
    Other(6),
    RentSubsidized(7),
    RentUnsubsidized(8);

    private final int id;

    HousingType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
