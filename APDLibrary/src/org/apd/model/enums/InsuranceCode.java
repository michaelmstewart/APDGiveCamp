package org.apd.model.enums;

/**
 * org.apd.model.enums.InsuranceCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum InsuranceCode {

    Private(1),
    Medicaid(2),
    MedicarePartAOrB(3),
    None(4),
    MedicarePartC(5),
    MedicarePartD(6),
    Other(100);

    private final int id;

    InsuranceCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

