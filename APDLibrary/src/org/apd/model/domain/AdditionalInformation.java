package org.apd.model.domain;

import org.apd.model.enums.CommFormatCode;

public class AdditionalInformation extends Base {
    private Boolean plan504;
    private Boolean planIep;
    private Boolean registeredVoter;
    private Boolean becomeRegisteredVoter;
    private String howLearnedAboutAlliance;
    private String referredFromAgency;
    private CommFormatCode alternateFormatsRequested;
    private Boolean accessAssistiveTechnology;
    private Boolean accessHealthCare;
    private Boolean accessTransportation;

    public AdditionalInformation() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public AdditionalInformation(Boolean plan504, Boolean planIep, Boolean registeredVoter, Boolean becomeRegisteredVoter,
                                 String howLearnedAboutAlliance, String referredFromAgency, CommFormatCode alternateFormatsRequested,
                                 Boolean accessAssistiveTechnology, Boolean accessHealthCare, Boolean accessTransportation){
        this.setPlan504(plan504);
        this.setPlanIep(planIep);
        this.setRegisteredVoter(registeredVoter);
        this.setBecomeRegisteredVoter(becomeRegisteredVoter);
        this.setHowLearnedAboutAlliance(howLearnedAboutAlliance);
        this.setReferredFromAgency(referredFromAgency);
        this.setAlternateFormatsRequested(alternateFormatsRequested);
        this.setAccessAssistiveTechnology(accessAssistiveTechnology);
        this.setAccessHealthCare(accessHealthCare);
        this.setAccessTransportation(accessTransportation);
    }

    public String toCsv() {
        return Base.PrintObjectNull(this.getPlan504()) + "," +
                Base.PrintObjectNull(this.getPlanIep()) + "," +
                Base.PrintObjectNull(this.getRegisteredVoter()) + "," +
                Base.PrintObjectNull(this.getBecomeRegisteredVoter()) + "," +
                Base.PrintStringNull(this.getHowLearnedAboutAlliance()) + "," +
                Base.PrintStringNull(this.getReferredFromAgency()) + "," +
                Base.PrintObjectNull(this.getAlternateFormatsRequested() != null ? this.getAlternateFormatsRequested().ordinal() : this.getAlternateFormatsRequested()) + "," +
                Base.PrintObjectNull(this.getAccessAssistiveTechnology()) + "," +
                Base.PrintObjectNull(this.getAccessHealthCare()) + "," +
                Base.PrintObjectNull(this.getAccessTransportation());
    }

    public Boolean getPlan504() {
        return plan504;
    }

    public void setPlan504(Boolean plan504) {
        this.plan504 = plan504;
    }

    public Boolean getRegisteredVoter() {
        return registeredVoter;
    }

    public void setRegisteredVoter(Boolean registeredVoter) {
        this.registeredVoter = registeredVoter;
    }

    public Boolean getBecomeRegisteredVoter() {
        return becomeRegisteredVoter;
    }

    public void setBecomeRegisteredVoter(Boolean becomeRegisteredVoter) {
        this.becomeRegisteredVoter = becomeRegisteredVoter;
    }

    public String getHowLearnedAboutAlliance() {
        return howLearnedAboutAlliance;
    }

    public void setHowLearnedAboutAlliance(String howLearnedAboutAlliance) {
        this.howLearnedAboutAlliance = howLearnedAboutAlliance;
    }

    public String getReferredFromAgency() {
        return referredFromAgency;
    }

    public void setReferredFromAgency(String referredFromAgency) {
        this.referredFromAgency = referredFromAgency;
    }

    public CommFormatCode getAlternateFormatsRequested() {
        return alternateFormatsRequested;
    }

    public void setAlternateFormatsRequested(CommFormatCode alternateFormatsRequested) {
        this.alternateFormatsRequested = alternateFormatsRequested;
    }

    public Boolean getAccessAssistiveTechnology() {
        return accessAssistiveTechnology;
    }

    public void setAccessAssistiveTechnology(Boolean accessAssistiveTechnology) {
        this.accessAssistiveTechnology = accessAssistiveTechnology;
    }

    public Boolean getAccessHealthCare() {
        return accessHealthCare;
    }

    public void setAccessHealthCare(Boolean accessHealthCare) {
        this.accessHealthCare = accessHealthCare;
    }

    public Boolean getAccessTransportation() {
        return accessTransportation;
    }

    public void setAccessTransportation(Boolean accessTransportation) {
        this.accessTransportation = accessTransportation;
    }

    public Boolean getPlanIep() {
        return planIep;
    }

    public void setPlanIep(Boolean planIep) {
        this.planIep = planIep;
    }
}
