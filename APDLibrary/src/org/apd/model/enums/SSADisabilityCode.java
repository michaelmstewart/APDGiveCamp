package org.apd.model.enums;

/**
 * org.apd.model.enums.SSADisabilityCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum SSADisabilityCode {

    BlindOrVisualImpairment(1),
    HearingSpeechAndOtherSensoryImpairments(2),
    SpinalCordInjury(3),
    NonSpinalCordOrthopedicDisablitiesOrAmputation(4),
    MentalAndEmotionalDisorders(5),
    CognitiveDisabilitiesLikeMentalRetardation(6),
    SystemDiseasesLikeNervousEndocrineCardiac(7),
    TraumaticBrainInjury(8),
    Other(9);
    
    private final int id;

    SSADisabilityCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

