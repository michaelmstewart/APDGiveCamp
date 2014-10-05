package org.apd.model.enums;

/**
 * org.apd.model.enums.AttendantAttributeTypeCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum AttendantAttributeTypeCode {

    Disabilities(1),
    Languages(2),
    Certifications(3),
    Domestic(4),
    Personal(5),
    Preferences(6),
    Driving(7);

    private final int id;

    AttendantAttributeTypeCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

