package org.apd.model.enums;

/**
 * org.apd.model.enums.CommFormatCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum CommFormatCode {

    None(0),
    Standard(1),
    LargePrint(2),
    Braille(3),
    AudioTape(4),
    CD(5),
    EmailStandard(6),
    EmailLargePrint(7);

    private final int id;

    CommFormatCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

