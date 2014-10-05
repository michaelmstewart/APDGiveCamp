package org.apd.model.enums;

/**
 * org.apd.model.enums.KeywordCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum KeywordCode {

    AccessOrBarrierRemoval(1),
    AdaptiveEquipment(2),
    Advocacy(3),
    AttendantServices(4),
    Attorneys(5),
    BenefitsOrEntitlements(6),
    CaseManagement(7),
    CivilLegalOrConsumerRights(8),
    Communication(9),
    CounselingMental(10),
    Courts(11),
    Daycare(12),
    DisabilityOrganization(13),
    EducationOrTraining(14),
    EmploymentOrVocation(15),
    Enforcement(16),
    FinancialAssistance(17),
    FoodOrNutrition(18),
    Government(19),
    HealthCare(20),
    Housing(21),
    HomeHealth(22),
    Media(23),
    Mobility(24),
    PeerSupport(25),
    PublicHealth(26),
    PublicSafety(27),
    Publication(28),
    RecreationOrLeisure(29),
    Rehabilitation(30),
    ReligionOrFaith(31),
    TechnicalAssistance(32),
    Transportation(33),
    Volunteers(34),
    Custom(99);
    
    private final int id;

    KeywordCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

