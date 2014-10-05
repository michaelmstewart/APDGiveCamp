package org.apd.view.panel;

import org.apd.model.domain.Customer;
import org.apd.model.domain.EligibilityForm;
import org.apd.model.enums.LivingServicesType;
import org.apd.model.enums.SSADisabilityCode;

import javax.swing.*;
import java.util.Date;

/**
 * Created by michaelstewart on 10/5/14.
 */
public class EligibilityPanel extends JComponent {
    public EligibilityPanel() {
        this.setName("Eligibility Form");
    }

    public EligibilityForm OnSubmit(Customer customer) {
        return new EligibilityForm(LivingServicesType.APDWestKing, customer, SSADisabilityCode.BlindOrVisualImpairment, null, "eligibilityAdditionalComments", false, false, false, false, false, false, "limitedOther", true, new Date(), false, new Date());
    }
}
