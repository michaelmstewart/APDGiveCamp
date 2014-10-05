package org.apd.model.enums;

/**
 * org.apd.model.enums.BFSEducationLevel
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum BFSEducationLevel {

    NoFormalSchooling(1),
    ElementaryEducation(2),
    SomeHighSchool(3),
    HighSchoolDiplomaOrEquivalent(4),
    SomeCollege(5),
    BachelorsDegree(6),
    MastersDegree(7);

    private final int id;

    BFSEducationLevel(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

