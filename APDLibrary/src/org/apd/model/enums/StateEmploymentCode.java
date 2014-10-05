package org.apd.model.enums;

/**
 * org.apd.model.enums.StateEmploymentCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum StateEmploymentCode {

    Unknown(0),
    FullTime(1),
    PartTime(2),
    LookingForAJob(3),
    UnemployedAndNotLooking(4),
    StudentOrInAProgram(5),
    Retired(6),
    ParticipatingInSegregatedWorkOrDayProgram(7),
    OtherEmployment(8);

    private final int id;

    StateEmploymentCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

