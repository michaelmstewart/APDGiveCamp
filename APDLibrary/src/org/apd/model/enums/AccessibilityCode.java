package org.apd.model.enums;

/**
 * org.apd.model.enums.AccessibilityCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum AccessibilityCode {

    Accessible(1),
    NotAccessible(2),
    NotReported(3);

    private final int id;

    AccessibilityCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

