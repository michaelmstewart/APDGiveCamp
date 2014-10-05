package org.apd.model.enums;

/**
 * org.apd.model.enums.FieldType
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum FieldType {

    BusinessSkillsOrClerical(1),
    InformationSystemsTechnology(2),
    LaboratoryAssistant(3),
    PCTraining(4),
    Step(5),
    Retail(6),
    Health_Related_Occupations(7),
    OfficeTechnology(8),
    ProfessionalOrAccountingOrEducationEtc(9),
    Banking(10),
    HospitalityOrRestaurantHotelsEtc(11),
    Customer_Service(12),
    Manufacturing(13),
    WorkplaceLiteracyOrAdultBasicEducation(14),
    GEDPreparation(15),
    EntreprenurialProgram(16),
    Other(17);

    private final int id;

    FieldType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

