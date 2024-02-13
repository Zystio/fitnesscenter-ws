package com.gouriny.fitnesscenterws.membershipsubdomain.presentationlayer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MembershipResponseModel {

    String membershipId;
    String type;
    String status;
    String billingType;
    Double cardFee;
    Double registrationFee;
    Double monthlyFee;
}
