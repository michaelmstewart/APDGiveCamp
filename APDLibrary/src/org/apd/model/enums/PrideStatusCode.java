package org.apd.model.enums;

/**
 * org.apd.model.enums.PrideStatusCode
 *
 * @author Steve Lewis
 * @date 10/4/14
 */
public enum PrideStatusCode {

    Pending_decision_from_fair_hearing(1),
    Pending_Decision_from_Application(2),
    Reconsideration_RT_PARENsending_it_offLT_PAREN(3),
    Pending_Decision_from_Reconsideration(4),
    Pending_Fair_Hearing(5),
    Pending_Decision_from_Fair_Hearing(6),
    Filed_in_Appeals_Court(7),
    Pending_Decision_from_Appeals_Court(8),
    Pending_Decision_from_Federal_Court(9),
    Accepted_DASH_SSI(10),
    Accepted_DASH_SSDI(11),
    Referred_Back_to_Provider(12),
    Not_Yet_Seen(13),
    in_application(14);

    private final int id;

    PrideStatusCode(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

