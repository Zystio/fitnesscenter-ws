package com.gouriny.fitnesscenterws.membershipsubdomain.presentationlayer;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class MembershipResponseModel extends RepresentationModel<MembershipResponseModel> {

    String membershipId;
    String membershipType;
    String status;
    String billingType;

    Double cardFee;
    Double registrationFee;

    Double payment;
    String paymentDueDate;
}
