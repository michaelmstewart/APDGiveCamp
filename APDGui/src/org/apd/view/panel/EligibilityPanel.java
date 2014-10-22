package org.apd.view.panel;

import org.apd.model.domain.Customer;
import org.apd.model.domain.EligibilityForm;
import org.apd.model.enums.LivingServicesType;
import org.apd.model.enums.SSADisabilityCode;
import org.apd.view.components.LabeledTextField;
import org.apd.view.panel.eligibility.EligibilityFormPanel;
import org.apd.view.panel.intake.AdditionalInformationPanel;
import org.apd.view.panel.intake.DemographicInformationPanel;
import org.apd.view.panel.intake.HousingInformationPanel;
import org.apd.view.panel.intake.MiscellaneousPanel;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EligibilityPanel extends JComponent {
    protected SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/YYYY");

    EligibilityFormPanel eligibilityFormPanel;

    public EligibilityPanel() {
        this.setName("Eligibility Form");

        setLayout(new BorderLayout());
        ScrollablePanel centerPanel = new ScrollablePanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.setAlignmentX(0);
        this.eligibilityFormPanel = new EligibilityFormPanel();
        centerPanel.add(this.eligibilityFormPanel);
        JScrollPane scrollPane = new JScrollPane(centerPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    public EligibilityForm OnSubmit(Customer customer) {

        LivingServicesType livingServicesType = null;
        if (this.eligibilityFormPanel.getEligibilityWestKing().isSelected()) {
            livingServicesType = LivingServicesType.APDWestKing;
        } else if (this.eligibilityFormPanel.getEligibilityEastKing().isSelected()) {
            livingServicesType = LivingServicesType.APDEastKing;
        } else if (this.eligibilityFormPanel.getEligibilityDisabilitiesLaw().isSelected()) {
            livingServicesType = LivingServicesType.DisabilitiesLawProject;
        }

        SSADisabilityCode primaryDisability = null;
        switch(this.eligibilityFormPanel.getPrimaryDisability().getDropdown().getSelectedIndex()) {
            case 1:
                primaryDisability = SSADisabilityCode.BlindOrVisualImpairment;
                break;
            case 2:
                primaryDisability = SSADisabilityCode.HearingSpeechAndOtherSensoryImpairments;
                break;
            case 3:
                primaryDisability = SSADisabilityCode.SpinalCordInjury;
                break;
            case 4:
                primaryDisability = SSADisabilityCode.NonSpinalCordOrthopedicDisablitiesOrAmputation;
                break;
            case 5:
                primaryDisability = SSADisabilityCode.MentalAndEmotionalDisorders;
                break;
            case 6:
                primaryDisability = SSADisabilityCode.CognitiveDisabilitiesLikeMentalRetardation;
                break;
            case 7:
                primaryDisability = SSADisabilityCode.SystemDiseasesLikeNervousEndocrineCardiac;
                break;
            case 8:
                primaryDisability = SSADisabilityCode.TraumaticBrainInjury;
                break;
            case 9:
                primaryDisability = SSADisabilityCode.Other;
                break;
        }

        SSADisabilityCode secondaryDisability = null;
        switch(this.eligibilityFormPanel.getSecondaryDisability().getDropdown().getSelectedIndex()) {
            case 1:
                secondaryDisability = SSADisabilityCode.BlindOrVisualImpairment;
                break;
            case 2:
                secondaryDisability = SSADisabilityCode.HearingSpeechAndOtherSensoryImpairments;
                break;
            case 3:
                secondaryDisability = SSADisabilityCode.SpinalCordInjury;
                break;
            case 4:
                secondaryDisability = SSADisabilityCode.NonSpinalCordOrthopedicDisablitiesOrAmputation;
                break;
            case 5:
                secondaryDisability = SSADisabilityCode.MentalAndEmotionalDisorders;
                break;
            case 6:
                secondaryDisability = SSADisabilityCode.CognitiveDisabilitiesLikeMentalRetardation;
                break;
            case 7:
                secondaryDisability = SSADisabilityCode.SystemDiseasesLikeNervousEndocrineCardiac;
                break;
            case 8:
                secondaryDisability = SSADisabilityCode.TraumaticBrainInjury;
                break;
            case 9:
                secondaryDisability = SSADisabilityCode.Other;
                break;
        }

        return new EligibilityForm(livingServicesType,
                customer,
                primaryDisability,
                secondaryDisability,
                this.eligibilityFormPanel.getAdditionalComments().getTextField().getText(),
                this.eligibilityFormPanel.getLimitedSelfCare().isSelected(),
                this.eligibilityFormPanel.getLimitedMobility().isSelected(),
                this.eligibilityFormPanel.getLimitedEducation().isSelected(),
                this.eligibilityFormPanel.getLimitedCommunication().isSelected(),
                this.eligibilityFormPanel.getLimitedResidentialOrHousing().isSelected(),
                this.eligibilityFormPanel.getLimitedVocationalOrEmployment().isSelected(),
                this.eligibilityFormPanel.getLimitedOther().getTextField().getText(),
                this.eligibilityFormPanel.getCustomerConsentCheckbox().isSelected(),
                new Date(),
                this.eligibilityFormPanel.getStaffConsentCheckbox().isSelected(),
                new Date());
    }

    public void Reset() {
        this.eligibilityFormPanel.Reset();
    }
}
