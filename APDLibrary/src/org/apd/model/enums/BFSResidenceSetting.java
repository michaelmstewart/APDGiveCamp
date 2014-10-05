package org.apd.model.enums;

/**
 * org.apd.model.enums.BFSResidenceSetting
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum BFSResidenceSetting {

    PrivateResidence(1),
    CommunityResidence(2),
    AssistedLivingCenter(3),
    NursingHome(4),
    Homeless(6);

    private final int id;

    BFSResidenceSetting(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

