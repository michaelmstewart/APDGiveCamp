package org.apd.model.enums;

/**
 * org.apd.model.enums.ISServiceCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum ISServiceCode {

    AdvocacyOrLegal(1),
    AssistiveDevices(2),
    Children(3),
    Communication(4),
    CounselingAndRelated(5),
    Family(6),
    HousingHomeModificationsAndShelter(7),
    InformationAndReferral(8),
    ILSkillsTrainingandLifeSkillsTraining(9),
    MentalRestoration(10),
    MobilityTraining(11),
    PeerCounselingIncludingCrossDisabilityPeerCounseling(12),
    PersonalAssistanceServices(13),
    PhysicalRehabilitation(14),
    PreventativeServices(15),
    ProsthesesAndOther(16),
    Recreational(17),
    RehabilitationTechnology(18),
    TherapeuticTreatment(19),
    Transportation(20),
    Youth(21),
    Vocational(22),
    Other(23);
    
    private final int id;

    ISServiceCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

