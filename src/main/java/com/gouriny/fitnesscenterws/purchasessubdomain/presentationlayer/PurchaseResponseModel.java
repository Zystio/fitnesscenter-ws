package com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer;

import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.Status;
import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.Type;
import com.gouriny.fitnesscenterws.purchasessubdomain.datalayer.CreditCardType;
import com.gouriny.fitnesscenterws.purchasessubdomain.datalayer.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)

public class PurchaseResponseModel {
    private String purchaseId;

    private String membershipId;
    private Type membershipType;

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
