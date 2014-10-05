package org.apd.model.enums;

/**
 * org.apd.model.enums.AtTargetedOutreach
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum AtTargetedOutreach {

    PsychiatricDisability(1),
    TBI(2),
    Multicultural(3),
    Seniors(4),
    ChildOrYouth(5),
    RuralAreas(6),
    Vendors(7),
    Other(8);

    private final int id;

    AtTargetedOutreach(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

