package org.apd.model.enums;

/**
 * org.apd.model.enums.TitleCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum TitleCode {

    Dr(1),
    Hon(2),
    Mr(3),
    Mrs(4),
    Ms(5),
    Sir(6),
    Madame(7);

    private final int id;

    TitleCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

