package com.gouriny.fitnesscenterws.membershipsubdomain.datalayer;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class NextPayment {

    private Double payment;
    private String paymentDueDate;
}
