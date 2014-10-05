package org.apd.model.enums;

/**
 * org.apd.model.enums.AttendantWageCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum AttendantWageCode {

    Hourly(1),
    Overnight(2),
    AllDayAvailability(3),
    LiveIn(4);

    private final int id;

    AttendantWageCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

