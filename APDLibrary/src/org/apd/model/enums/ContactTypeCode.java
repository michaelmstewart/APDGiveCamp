package org.apd.model.enums;

/**
 * org.apd.model.enums.ContactTypeCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum ContactTypeCode {

    Phone(1),
    OfficeVisit(2),
    HomeVisit(3);

    private final int id;

    ContactTypeCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

