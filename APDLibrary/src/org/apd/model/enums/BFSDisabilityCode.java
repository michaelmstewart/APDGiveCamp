package org.apd.model.enums;

/**
 * org.apd.model.enums.BFSDisabilityCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum BFSDisabilityCode {

    LegallyBlind(1),
    SevereVisualImpairment(2),
    TotallyBlind(3);

    private final int id;

    BFSDisabilityCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

