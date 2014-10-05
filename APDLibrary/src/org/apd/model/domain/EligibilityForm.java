package org.apd.model.domain;

import org.apd.model.enums.LivingServicesType;
import org.apd.model.enums.SSADisabilityCode;

import java.util.Date;

public class EligibilityForm extends Base {
    private LivingServicesType livingServicesType;
    private Customer customer;
    private SSADisabilityCode primaryDisability;
    private SSADisabilityCode secondaryDisability;
    private String additionalComments;
    private Boolean limitedSelfCare;
    private Boolean limitedMobility;
    private Boolean limitedEducation;
    private Boolean limitedCommunication;
    private Boolean limitedResidentialOrHousing;
    private Boolean limitedVocationOrEmployment;
    private String limitedOther;
    private Boolean customerConsent;
    private Date customerSignOffDate;
    private Boolean staffConsent;
    private Date staffSignOffDate;

    public EligibilityForm() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public EligibilityForm(LivingServicesType livingServicesType, Customer customer, SSADisabilityCode primaryDisability, SSADisabilityCode secondaryDisability, String additionalComments,
                           Boolean limitedSelfCare, Boolean limitedMobility, Boolean limitedEducation, Boolean limitedCommunication,
                           Boolean limitedResidentialOrHousing, Boolean limitedVocationOrEmployment, String limitedOther, Boolean customerConsent,
                           Date customerSignOffDate, Boolean staffConsent, Date staffSignOffDate) {
        this.setLivingServicesType(livingServicesType);
        this.setCustomer(customer);
        this.setPrimaryDisability(primaryDisability);
        this.setSecondaryDisability(secondaryDisability);
        this.setAdditionalComments(additionalComments);
        this.setLimitedSelfCare(limitedSelfCare);
        this.setLimitedMobility(limitedMobility);
        this.setLimitedEducation(limitedEducation);
        this.setLimitedCommunication(limitedCommunication);
        this.setLimitedResidentialOrHousing(limitedResidentialOrHousing);
        this.setLimitedVocationOrEmployment(limitedVocationOrEmployment);
        this.setLimitedOther(limitedOther);
        this.setCustomerConsent(customerConsent);
        this.setCustomerSignOffDate((customerSignOffDate == null ? new Date() : customerSignOffDate));
        this.setStaffConsent(staffConsent);
        this.setStaffSignOffDate((staffSignOffDate == null ? new Date() : staffSignOffDate));
    }

    public String toCsv() {
        return Base.PrintStringNull(this.getLivingServicesType().toString()) + "," +
                Base.PrintObjectNull(this.getPrimaryDisability() != null ? this.getPrimaryDisability().ordinal() : this.getPrimaryDisability()) + "," +
                Base.PrintObjectNull(this.getSecondaryDisability() != null ? this.getSecondaryDisability().ordinal() : this.getSecondaryDisability()) + "," +
                Base.PrintStringNull(this.getAdditionalComments()) + "," +
                Base.PrintObjectNull(this.getLimitedSelfCare()) + "," +
                Base.PrintObjectNull(this.getLimitedMobility()) + "," +
                Base.PrintObjectNull(this.getLimitedEducation()) + "," +
                Base.PrintObjectNull(this.getLimitedCommunication()) + "," +
                Base.PrintObjectNull(this.getLimitedResidentialOrHousing()) + "," +
                Base.PrintObjectNull(this.getLimitedVocationOrEmployment()) + "," +
                Base.PrintStringNull(this.getLimitedOther()) + "," +
                Base.PrintObjectNull(this.getCustomerConsent()) + "," +
                Base.PrintObjectNull(dateFormat.format(this.getCustomerSignOffDate())) + "," +
                Base.PrintObjectNull(this.getStaffConsent()) + "," +
                Base.PrintObjectNull(dateFormat.format(this.getStaffSignOffDate()));
    }

    public LivingServicesType getLivingServicesType() {
        return livingServicesType;
    }

    public void setLivingServicesType(LivingServicesType livingServicesType) {
        this.livingServicesType = livingServicesType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SSADisabilityCode getPrimaryDisability() {
        return primaryDisability;
    }

    public void setPrimaryDisability(SSADisabilityCode primaryDisability) {
        this.primaryDisability = primaryDisability;
    }

    public SSADisabilityCode getSecondaryDisability() {
        return secondaryDisability;
    }

    public void setSecondaryDisability(SSADisabilityCode secondaryDisability) {
        this.secondaryDisability = secondaryDisability;
    }

    public String getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(String additionalComments) {
        this.additionalComments = additionalComments;
    }

    public Boolean getLimitedSelfCare() {
        return limitedSelfCare;
    }

    public void setLimitedSelfCare(Boolean limitedSelfCare) {
        this.limitedSelfCare = limitedSelfCare;
    }

    public Boolean getLimitedMobility() {
        return limitedMobility;
    }

    public void setLimitedMobility(Boolean limitedMobility) {
        this.limitedMobility = limitedMobility;
    }

    public Boolean getLimitedEducation() {
        return limitedEducation;
    }

    public void setLimitedEducation(Boolean limitedEducation) {
        this.limitedEducation = limitedEducation;
    }

    public Boolean getLimitedCommunication() {
        return limitedCommunication;
    }

    public void setLimitedCommunication(Boolean limitedCommunication) {
        this.limitedCommunication = limitedCommunication;
    }

    public Boolean getLimitedResidentialOrHousing() {
        return limitedResidentialOrHousing;
    }

    public void setLimitedResidentialOrHousing(Boolean limitedResidentialOrHousing) {
        this.limitedResidentialOrHousing = limitedResidentialOrHousing;
    }

    public Boolean getLimitedVocationOrEmployment() {
        return limitedVocationOrEmployment;
    }

    public void setLimitedVocationOrEmployment(Boolean limitedVocationOrEmployment) {
        this.limitedVocationOrEmployment = limitedVocationOrEmployment;
    }

    public String getLimitedOther() {
        return limitedOther;
    }

    public void setLimitedOther(String limitedOther) {
        this.limitedOther = limitedOther;
    }

    public Boolean getCustomerConsent() {
        return customerConsent;
    }

    public void setCustomerConsent(Boolean customerConsent) {
        this.customerConsent = customerConsent;
    }

    public Date getCustomerSignOffDate() {
        return customerSignOffDate;
    }

    public void setCustomerSignOffDate(Date customerSignOffDate) {
        this.customerSignOffDate = customerSignOffDate;
    }

    public Boolean getStaffConsent() {
        return staffConsent;
    }

    public void setStaffConsent(Boolean staffConsent) {
        this.staffConsent = staffConsent;
    }

    public Date getStaffSignOffDate() {
        return staffSignOffDate;
    }

    public void setStaffSignOffDate(Date staffSignOffDate) {
        this.staffSignOffDate = staffSignOffDate;
    }
}