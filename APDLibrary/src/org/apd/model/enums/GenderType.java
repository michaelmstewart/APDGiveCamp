package org.apd.model.enums;

public enum GenderType {

    Male(1),
    Female(2),
    Unknown(3);

    private final int mapping;

    public int getMapping() {
        return this.mapping;
    }

    GenderType(int id) {
        this.mapping = id;
    }
}
