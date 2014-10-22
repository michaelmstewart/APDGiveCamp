package org.apd.view.panel.eligibility;

import org.apd.view.components.LabeledDropdown;
import org.apd.view.components.LabeledTextField;

import javax.swing.*;
import java.awt.*;

public class EligibilityFormPanel extends JPanel {
    JLabel serviceEligibility;
    private ButtonGroup eligibilityGroup;
    private JRadioButton eligibilityWestKing;
    private JRadioButton eligibilityEastKing;
    private JRadioButton eligibilityDisabilitiesLaw;
    JLabel introduction;
    JLabel statement;
    private LabeledDropdown primaryDisability;
    private LabeledDropdown secondaryDisability;
    private LabeledTextField additionalComments;
    JLabel limitationLabel;
    private JCheckBox limitedSelfCare;
    private JCheckBox limitedMobility;
    private JCheckBox limitedEducation;
    private JCheckBox limitedCommunication;
    private JCheckBox limitedResidentialOrHousing;
    private JCheckBox limitedVocationalOrEmployment;
    private LabeledTextField limitedOther;
    JLabel customerConsent;
    private JCheckBox customerConsentCheckbox;
    JLabel staffConsent;
    private JCheckBox staffConsentCheckbox;

    public EligibilityFormPanel() {
        InitializeComponents();
        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(this.serviceEligibility);
        centerPanel.add(this.getEligibilityWestKing());
        centerPanel.add(this.getEligibilityEastKing());
        centerPanel.add(this.getEligibilityDisabilitiesLaw());
        centerPanel.add(this.introduction);
        centerPanel.add(this.statement);
        centerPanel.add(this.getPrimaryDisability());
        centerPanel.add(this.getSecondaryDisability());
        centerPanel.add(this.getAdditionalComments());
        centerPanel.add(this.limitationLabel);

        JPanel limitationGridBag = new JPanel();
        limitationGridBag.setLayout(new GridLayout(3, 3));
        limitationGridBag.setAlignmentX(Component.LEFT_ALIGNMENT);
        limitationGridBag.add(this.getLimitedSelfCare());
        limitationGridBag.add(this.getLimitedMobility());
        limitationGridBag.add(this.getLimitedEducation());
        limitationGridBag.add(this.getLimitedCommunication());
        limitationGridBag.add(this.getLimitedResidentialOrHousing());
        limitationGridBag.add(this.getLimitedVocationalOrEmployment());
        limitationGridBag.add(this.getLimitedOther());
        centerPanel.add(limitationGridBag);

        centerPanel.add(this.customerConsent);
        centerPanel.add(this.getCustomerConsentCheckbox());
        centerPanel.add(this.staffConsent);
        centerPanel.add(this.getStaffConsentCheckbox());

        this.add(centerPanel, BorderLayout.CENTER);

        this.setBorder(BorderFactory.createBevelBorder(1));
    }

    private void InitializeComponents() {
        this.serviceEligibility = new JLabel("To be eligible for independent living services from:");
        this.setEligibilityGroup(new ButtonGroup());
        this.setEligibilityWestKing(new JRadioButton("Alliance of People with disAbilities – West King County"));
        this.setEligibilityEastKing(new JRadioButton("Alliance of People with disAbilities – East King County"));
        this.setEligibilityDisabilitiesLaw(new JRadioButton("Disabilities Law Project"));

        this.getEligibilityGroup().add(this.getEligibilityWestKing());
        this.getEligibilityGroup().add(this.getEligibilityEastKing());
        this.getEligibilityGroup().add(this.getEligibilityDisabilitiesLaw());

        this.introduction = new JLabel("<html><br/>A person must experience a significant disability that limits his or her ability to function independently.  As a means to document your eligibility for services, please answer the following questions:</html>");
        this.statement = new JLabel("<html><br/>I state that I have the following disability/ies:</html>");
        String[] disabilities = new String[]{
                "",
                "Blind Or Visual Impairment",
                "Hearing, Speech, And Other Sensory Impairments",
                "Spinal Cord Injury",
                "Non-Spinal Cord Orthopedic Disablities Or Amputation",
                "Mental And Emotional Disorders",
                "Cognitive Disabilities (Mental Retardation)",
                "System Diseases (Nervous, Endocrine, Cardiac)",
                "Traumatic Brain Injury",
                "Other"
        };
        this.setPrimaryDisability(new LabeledDropdown("Primary disAbility", disabilities));
        this.setSecondaryDisability(new LabeledDropdown("Secondary disAbility", disabilities));
        this.setAdditionalComments(new LabeledTextField("Additional comments", 25));

        this.limitationLabel = new JLabel("<html><br/>My disAbility substantially limits me from functioning independently in the following areas:</html>");
        this.setLimitedSelfCare(new JCheckBox("Self-Care"));
        this.setLimitedMobility(new JCheckBox("Mobility"));
        this.setLimitedEducation(new JCheckBox("Education"));
        this.setLimitedCommunication(new JCheckBox("Communication"));
        this.setLimitedResidentialOrHousing(new JCheckBox("Residential/Housing"));
        this.setLimitedVocationalOrEmployment(new JCheckBox("Vocational/Employment"));
        this.setLimitedOther(new LabeledTextField("Other", 10));

        this.customerConsent = new JLabel("<html><br/>Customer Consent</html>");
        this.setCustomerConsentCheckbox(new JCheckBox("By checking this box I consent the information above is accurate"));
        this.staffConsent = new JLabel("<html><br/>Staff Consent</html>");
        this.setStaffConsentCheckbox(new JCheckBox("In my opinion this person has a significant disability and is eligible for independent living services."));
    }

    public void Reset() {
        this.getEligibilityGroup().clearSelection();
    }

    public ButtonGroup getEligibilityGroup() {
        return eligibilityGroup;
    }

    public void setEligibilityGroup(ButtonGroup eligibilityGroup) {
        this.eligibilityGroup = eligibilityGroup;
    }

    public JRadioButton getEligibilityWestKing() {
        return eligibilityWestKing;
    }

    public void setEligibilityWestKing(JRadioButton eligibilityWestKing) {
        this.eligibilityWestKing = eligibilityWestKing;
    }

    public JRadioButton getEligibilityEastKing() {
        return eligibilityEastKing;
    }

    public void setEligibilityEastKing(JRadioButton eligibilityEastKing) {
        this.eligibilityEastKing = eligibilityEastKing;
    }

    public JRadioButton getEligibilityDisabilitiesLaw() {
        return eligibilityDisabilitiesLaw;
    }

    public void setEligibilityDisabilitiesLaw(JRadioButton eligibilityDisabilitiesLaw) {
        this.eligibilityDisabilitiesLaw = eligibilityDisabilitiesLaw;
    }

    public LabeledDropdown getPrimaryDisability() {
        return primaryDisability;
    }

    public void setPrimaryDisability(LabeledDropdown primaryDisability) {
        this.primaryDisability = primaryDisability;
    }

    public LabeledDropdown getSecondaryDisability() {
        return secondaryDisability;
    }

    public void setSecondaryDisability(LabeledDropdown secondaryDisability) {
        this.secondaryDisability = secondaryDisability;
    }

    public LabeledTextField getAdditionalComments() {
        return additionalComments;
    }

    public void setAdditionalComments(LabeledTextField additionalComments) {
        this.additionalComments = additionalComments;
    }

    public JCheckBox getLimitedSelfCare() {
        return limitedSelfCare;
    }

    public void setLimitedSelfCare(JCheckBox limitedSelfCare) {
        this.limitedSelfCare = limitedSelfCare;
    }

    public JCheckBox getLimitedMobility() {
        return limitedMobility;
    }

    public void setLimitedMobility(JCheckBox limitedMobility) {
        this.limitedMobility = limitedMobility;
    }

    public JCheckBox getLimitedEducation() {
        return limitedEducation;
    }

    public void setLimitedEducation(JCheckBox limitedEducation) {
        this.limitedEducation = limitedEducation;
    }

    public JCheckBox getLimitedCommunication() {
        return limitedCommunication;
    }

    public void setLimitedCommunication(JCheckBox limitedCommunication) {
        this.limitedCommunication = limitedCommunication;
    }

    public JCheckBox getLimitedResidentialOrHousing() {
        return limitedResidentialOrHousing;
    }

    public void setLimitedResidentialOrHousing(JCheckBox limitedResidentialOrHousing) {
        this.limitedResidentialOrHousing = limitedResidentialOrHousing;
    }

    public JCheckBox getLimitedVocationalOrEmployment() {
        return limitedVocationalOrEmployment;
    }

    public void setLimitedVocationalOrEmployment(JCheckBox limitedVocationalOrEmployment) {
        this.limitedVocationalOrEmployment = limitedVocationalOrEmployment;
    }

    public LabeledTextField getLimitedOther() {
        return limitedOther;
    }

    public void setLimitedOther(LabeledTextField limitedOther) {
        this.limitedOther = limitedOther;
    }

    public JCheckBox getCustomerConsentCheckbox() {
        return customerConsentCheckbox;
    }

    public void setCustomerConsentCheckbox(JCheckBox customerConsentCheckbox) {
        this.customerConsentCheckbox = customerConsentCheckbox;
    }

    public JCheckBox getStaffConsentCheckbox() {
        return staffConsentCheckbox;
    }

    public void setStaffConsentCheckbox(JCheckBox staffConsentCheckbox) {
        this.staffConsentCheckbox = staffConsentCheckbox;
    }
}
