package org.apd.model.enums;

/**
 * org.apd.model.enums.AccessCategory
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum AccessCategory {

    AssistiveTechnology(1),
    HealthCareServices(2),
    Transportation(3);

    private final int id;

    AccessCategory(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

