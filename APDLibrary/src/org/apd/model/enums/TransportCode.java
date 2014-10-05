package org.apd.model.enums;

/**
 * org.apd.model.enums.TransportCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum TransportCode {

    None(1),
    FamilyOrFriends(2),
    Taxi(3),
    PublicParatransit(4),
    PublicFixedRoute(5),
    DrivesOwnVehicle(6);

    private final int id;

    TransportCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

