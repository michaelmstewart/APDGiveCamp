package org.apd.model.enums;

public enum LivingServicesType {
    APDWestKing,
    APDEastKing,
    DisabilitiesLawProject;

    public String toString() {
        if(this.equals(LivingServicesType.APDWestKing)) {
            return "Alliance of People with disAbilities - West King County";
        } else if(this.equals(LivingServicesType.APDEastKing)) {
            return "Alliance of People with disAbilities - East King County";
        } else {
            return "Disabilities Law Project";
        }
    }
}
