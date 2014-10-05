package org.apd.model.domain;

public class IntakeForm extends Base {
    private Customer customer;
    private AdditionalInformation additionalInformation;
    private Demographics demographics;
    private String comments;
    private Boolean optOut;

    public IntakeForm() {

    }

    public IntakeForm(Customer customer, AdditionalInformation additionalInformation, Demographics demographics, String comments, Boolean optOut) {
        this.setCustomer(customer);
        this.setAdditionalInformation(additionalInformation);
        this.setDemographics(demographics);
        this.setComments(comments);
        this.setOptOut(optOut);
    }

    public String toCsv() {
        return this.getCustomer().toCsv() + "," +
                this.getDemographics().toCsv() + "," +
                this.getAdditionalInformation().toCsv() + "," +
                Base.PrintStringNull(this.getComments()) + "," +
                Base.PrintObjectNull(this.getOptOut());
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public AdditionalInformation getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(AdditionalInformation additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Demographics getDemographics() {
        return demographics;
    }

    public void setDemographics(Demographics demographics) {
        this.demographics = demographics;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getOptOut() {
        return optOut;
    }

    public void setOptOut(Boolean optOut) {
        this.optOut = optOut;
    }
}
