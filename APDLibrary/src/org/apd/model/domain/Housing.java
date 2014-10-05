package org.apd.model.domain;

import org.apd.model.enums.HousingType;

public class Housing extends Base {
    private Address homeAddress;
    private Address mailingAddress;
    private HousingType housingType;
    private Integer timesHomeless;
    private String lengthRecentHomeless;
    private Boolean nursingFacilityMoveRisk;

    public Housing() {
        this(null, null, null, null, null, null);
    }

    public Housing(Address homeAddress, Address mailingAddress, HousingType housingType,
                   Integer timesHomeless, String lengthRecentHomeless, Boolean nursingFacilityMoveRisk) {
        this.setHomeAddress((homeAddress == null ? new Address() : homeAddress));
        this.setMailingAddress((mailingAddress == null ? new Address() : mailingAddress));
        this.setHousingType(housingType);
        this.setTimesHomeless(timesHomeless);
        this.setLengthRecentHomeless(lengthRecentHomeless);
        this.setNursingFacilityMoveRisk(nursingFacilityMoveRisk);
    }

    public String toString() {
        return "" +
                this.getHomeAddress() + " " +
                this.getMailingAddress() + " " +
                this.getHousingType() + " " +
                this.getTimesHomeless() + " " +
                this.getLengthRecentHomeless() + " " +
                this.getNursingFacilityMoveRisk();
    }

    public String toCsv() {
        return this.getHomeAddress().toCsv() + "," +
                this.getMailingAddress().toCsv() + "," +
                Base.PrintObjectNull(this.getHousingType() !=null? this.getHousingType().ordinal(): this.getHousingType()) + "," +
                Base.PrintObjectNull(this.getTimesHomeless()) + "," +
                Base.PrintObjectNull(this.getLengthRecentHomeless()) + "," +
                Base.PrintObjectNull(this.getNursingFacilityMoveRisk());
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public HousingType getHousingType() {
        return housingType;
    }

    public void setHousingType(HousingType housingType) {
        this.housingType = housingType;
    }

    public Integer getTimesHomeless() {
        return timesHomeless;
    }

    public void setTimesHomeless(Integer timesHomeless) {
        this.timesHomeless = timesHomeless;
    }

    public String getLengthRecentHomeless() {
        return lengthRecentHomeless;
    }

    public void setLengthRecentHomeless(String lengthRecentHomeless) {
        this.lengthRecentHomeless = lengthRecentHomeless;
    }

    public Boolean getNursingFacilityMoveRisk() {
        return nursingFacilityMoveRisk;
    }

    public void setNursingFacilityMoveRisk(Boolean nursingFacilityMoveRisk) {
        this.nursingFacilityMoveRisk = nursingFacilityMoveRisk;
    }
}
