package com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer;

import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.Status;
import com.gouriny.fitnesscenterws.purchasessubdomain.datalayer.CreditCardType;
import com.gouriny.fitnesscenterws.purchasessubdomain.datalayer.PaymentType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;


@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PurchaseRequestModel {

//    private String purchaseId;
    private String membershipId;
    private String membershipType;

    private String memberId;
    private String memberFirstName;
    private String memberLastName;

    private String employeeId;
    private String employeeFirstName;
    private String employeeLastName;

    private Status status;
    private Double cardFee;
    private Double registrationFee;
    private Double monthlyFee;

    private PaymentType paymentType;
    private CreditCardType creditCardType;
    private LocalDate startDate;
}
