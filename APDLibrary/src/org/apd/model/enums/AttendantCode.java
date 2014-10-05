package org.apd.model.enums;

/**
 * org.apd.model.enums.AttendantCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum AttendantCode {

    NotAvailable(1),
    OutOfPocket(2),
    PrivateInsurance(3),
    Medicare(4),
    Medicaid(5),
    MedicaidWaiver(6),
    VeteransAdministration(7),
    VocationalOrRehabVR(8),
    SupportedLiving(9),
    NotNeeded(11),
    FamilyOrFriends(12),
    NoAttendant(13);

    private final int id;

    AttendantCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

