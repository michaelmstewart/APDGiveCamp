package org.apd.model.enums;

/**
 * org.apd.model.enums.StateEducationLevel
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum StateEducationLevel {

    Unknown(0),
    KTo8(1),
    SomeHighSchool(2),
    CompletedHighSchool(3),
    SomeCollege(4),
    BusinessTradeVocationalSchool(5),
    CompletedTwoYearUndergraduateProgram(6),
    CompletedFourYearUndergraduateProgram(7),
    CompletedPostGraduateProgram(8),
    PreKProgram(9),
    NotYetEnrolled(10);
    
    private final int id;

    StateEducationLevel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

