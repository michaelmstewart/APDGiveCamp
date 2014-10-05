package org.apd.model.domain;

import org.apd.model.enums.EthnicityType;
import org.apd.model.enums.GenderType;
import org.apd.model.enums.MaritalStatusCode;
import org.apd.model.enums.StateEmploymentCode;

import java.util.Date;

public class Demographics extends Base {
    private Date birthdate;
    private GenderType gender;
    private Integer numInHousehold;
    private Boolean singleParentHousehold;
    private GenderType singleParentHeadOfHouseGender;
    private Integer numChildrenUnderEighteen;
    private Double grossMonthlyHouseholdIncome;
    private MaritalStatusCode maritalStatus;
    private Boolean latinoOrHispanic;
    private EthnicityType ethnicity;
    private Boolean limitedEnglish;
    private Boolean immigrantRefugeeNewArrival;
    private Boolean employed;
    private StateEmploymentCode employmentStatus;
    private String comments;
    private Boolean veteranStatus;

    public Demographics() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public Demographics(Date birthdate, GenderType gender, Integer numInHousehold, Boolean singleParentHousehold,
                        GenderType singleParentHeadOfHouseGender, Integer numChildrenUnderEighteen, Double grossMonthlyHouseholdIncome,
                        MaritalStatusCode maritalStatus, Boolean latinoOrHispanic, EthnicityType ethnicity, Boolean limitedEnglish,
                        Boolean immigrantRefugeeNewArrival, Boolean employed, StateEmploymentCode employmentStatus, String comments,
                        Boolean veteranStatus) {
        this.setBirthdate(birthdate);
        this.setGender(gender);
        this.setNumInHousehold(numInHousehold);
        this.setSingleParentHousehold(singleParentHousehold);
        this.setSingleParentHeadOfHouseGender(singleParentHeadOfHouseGender);
        this.setNumChildrenUnderEighteen(numChildrenUnderEighteen);
        this.setGrossMonthlyHouseholdIncome(grossMonthlyHouseholdIncome);
        this.setMaritalStatus(maritalStatus);
        this.setLatinoOrHispanic(latinoOrHispanic);
        this.setEthnicity(ethnicity);
        this.setLimitedEnglish(limitedEnglish);
        this.setImmigrantRefugeeNewArrival(immigrantRefugeeNewArrival);
        this.setEmployed(employed);
        this.setEmploymentStatus(employmentStatus);
        this.setComments(comments);
        this.setVeteranStatus(veteranStatus);
    }

    public String toCsv() {
        return (this.getBirthdate() == null ? "" : super.dateFormat.format(this.getBirthdate())) + "," +
                Base.PrintObjectNull(this.getGender() != null ? this.getGender().ordinal() : this.getGender()) + "," +
                Base.PrintObjectNull(this.getNumInHousehold()) + "," +
                Base.PrintObjectNull(this.getSingleParentHousehold()) + "," +
                Base.PrintObjectNull((this.getSingleParentHeadOfHouseGender() != null ? this.getSingleParentHeadOfHouseGender().ordinal() : this.getSingleParentHeadOfHouseGender())) + "," +
                Base.PrintObjectNull(this.getNumChildrenUnderEighteen()) + "," +
                Base.PrintObjectNull(this.getGrossMonthlyHouseholdIncome()) + "," +
                Base.PrintObjectNull((this.getMaritalStatus() != null ? this.getMaritalStatus().ordinal() : this.getMaritalStatus())) + "," +
                Base.PrintObjectNull(this.getLatinoOrHispanic()) + "," +
                Base.PrintObjectNull((this.getEthnicity() != null ? this.getEthnicity().ordinal() : this.getEthnicity())) + "," +
                Base.PrintObjectNull(this.getLimitedEnglish()) + "," +
                Base.PrintObjectNull(this.getImmigrantRefugeeNewArrival()) + "," +
                Base.PrintObjectNull(this.getEmployed()) + "," +
                Base.PrintObjectNull((this.getEmploymentStatus() != null ? this.getEmploymentStatus().ordinal() : this.getEmploymentStatus())) + "," +
                Base.PrintStringNull(this.getComments()) + "," +
                Base.PrintObjectNull(this.getVeteranStatus());
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public Integer getNumInHousehold() {
        return numInHousehold;
    }

    public void setNumInHousehold(Integer numInHousehold) {
        this.numInHousehold = numInHousehold;
    }

    public Boolean getSingleParentHousehold() {
        return singleParentHousehold;
    }

    public void setSingleParentHousehold(Boolean singleParentHousehold) {
        this.singleParentHousehold = singleParentHousehold;
    }

    public GenderType getSingleParentHeadOfHouseGender() {
        return singleParentHeadOfHouseGender;
    }

    public void setSingleParentHeadOfHouseGender(GenderType singleParentHeadOfHouseGender) {
        this.singleParentHeadOfHouseGender = singleParentHeadOfHouseGender;
    }

    public Integer getNumChildrenUnderEighteen() {
        return numChildrenUnderEighteen;
    }

    public void setNumChildrenUnderEighteen(Integer numChildrenUnderEighteen) {
        this.numChildrenUnderEighteen = numChildrenUnderEighteen;
    }

    public Double getGrossMonthlyHouseholdIncome() {
        return grossMonthlyHouseholdIncome;
    }

    public void setGrossMonthlyHouseholdIncome(Double grossMonthlyHouseholdIncome) {
        this.grossMonthlyHouseholdIncome = grossMonthlyHouseholdIncome;
    }

    public MaritalStatusCode getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatusCode maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Boolean getLatinoOrHispanic() {
        return latinoOrHispanic;
    }

    public void setLatinoOrHispanic(Boolean latinoOrHispanic) {
        this.latinoOrHispanic = latinoOrHispanic;
    }

    public EthnicityType getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(EthnicityType ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Boolean getLimitedEnglish() {
        return limitedEnglish;
    }

    public void setLimitedEnglish(Boolean limitedEnglish) {
        this.limitedEnglish = limitedEnglish;
    }

    public Boolean getImmigrantRefugeeNewArrival() {
        return immigrantRefugeeNewArrival;
    }

    public void setImmigrantRefugeeNewArrival(Boolean immigrantRefugeeNewArrival) {
        this.immigrantRefugeeNewArrival = immigrantRefugeeNewArrival;
    }

    public Boolean getEmployed() {
        return employed;
    }

    public void setEmployed(Boolean employed) {
        this.employed = employed;
    }

    public StateEmploymentCode getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(StateEmploymentCode employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getVeteranStatus() {
        return veteranStatus;
    }

    public void setVeteranStatus(Boolean veteranStatus) {
        this.veteranStatus = veteranStatus;
    }
}
