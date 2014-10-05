package org.apd.model.enums;

/**
 * org.apd.model.enums.TrainingCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum TrainingCode {

    FormalizedTraining(1),
    InternshipsOrWorkExperiences(2),
    CompanyFacilitated(3),
    PaceAndTrainOJT(4),
    WorkAdjustmentTraining(5),
    None(6);
    
    private final int id;

    TrainingCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

