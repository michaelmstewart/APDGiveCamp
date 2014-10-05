package org.apd.model.enums;

/**
 * org.apd.model.enums.AttendantProficiencyCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum AttendantProficiencyCode {

    None(1),
    NoneOrWillingToLearn(2),
    SomeExperience(3),
    Expert(4),
    Certified(5);

    private final int id;

    AttendantProficiencyCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

