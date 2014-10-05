package org.apd.model.enums;

/**
 * org.apd.model.enums.StateServiceCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum StateServiceCode {

    AdvocacyLegal(1),
    ArchitecturalBarrierServices(2),
    AssistiveDevicesEquipment(3),
    ChildrensServices(4),
    CommunicationServices(5),
    CounselingServices(6),
    FamilyServices(7),
    HousingAndShelterServices(8),
    InformationAndReferral(9),
    ILSkillsTrainingAndLifeSkillsTraining(10),
    MobilityTraining(11),
    PeerCounseling(12),
    PersonalAssistanceServices(13),
    Recreational(14),
    Transportation(15),
    Youth(16),
    VocationalServices(17),
    PlanForTheAchievementOfSelfSupport(18),
    BusinessSLASHIndustryOrAgencyServices(19),
    BenefitsAdvisement(20),
    VoterRegistration(21),
    Other(22);

    private final int id;

    StateServiceCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

