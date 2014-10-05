package org.apd.model.enums;

/**
 * org.apd.model.enums.BFSReferralSource
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum BFSReferralSource {

    EyeCareProvider(1),
    OtherDoctor(2),
    StateVRAgency(3),
    SocialServiceAgency(4),
    SelfReferral(5),
    FamilyMemberOrFriend(6),
    VeteransAdministration(7),
    SeniorProgram(8),
    ReligiousOrganization(9),
    CommunityRehabilitationProgram(10),
    Other(11),
    AssistedLiving(12),
    NursingHome(13);

    private final int id;

    BFSReferralSource(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

