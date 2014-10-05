package org.apd.model.enums;

/**
 * org.apd.model.enums.BFSBlindnessCause
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum BFSBlindnessCause {

    MacularDegeneration(1),
    DiabeticRetinopathy(2),
    Glaucoma(3),
    Cataracts(4),
    Other(5);

    private final int id;

    BFSBlindnessCause(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

