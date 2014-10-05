package org.apd.model.enums;

/**
 * org.apd.model.enums.BFSLivingArrangement
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum BFSLivingArrangement {

    LivingAlone(1),
    LivingWithSpouse(2),
    LivingWithAssistant(3),
    LivingWithOther(4);

    private final int id;

    BFSLivingArrangement(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

