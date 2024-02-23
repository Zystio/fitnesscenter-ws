package com.gouriny.fitnesscenterws.membershipsubdomain.datalayer;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class InitialFees {
    private Double cardFee;
    private Double registrationFee;
}
