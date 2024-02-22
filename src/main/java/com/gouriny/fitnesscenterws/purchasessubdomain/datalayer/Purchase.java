package com.gouriny.fitnesscenterws.purchasessubdomain.datalayer;

import com.gouriny.fitnesscenterws.common.EmployeeIdentifier;
import com.gouriny.fitnesscenterws.common.MemberIdentifier;
import com.gouriny.fitnesscenterws.common.MembershipIdentifier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "purchases")
@Data

public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    PurchaseIdentifier purchaseIdentifier;

    @Embedded
    MemberIdentifier memberIdentifier;

    @Embedded
    EmployeeIdentifier employeeIdentifier;

    @Embedded
    MembershipIdentifier membershipIdentifier;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    private CreditCardType creditCardType;
    private LocalDate startDate;

    public Purchase() {
    }

    public Purchase(@NotNull MemberIdentifier memberIdentifier, @NotNull EmployeeIdentifier employeeIdentifier, @NotNull MembershipIdentifier membershipIdentifier,
                    @NotNull PaymentType paymentType, CreditCardType creditCardType,
                    @NotNull LocalDate startDate) {
        this.purchaseIdentifier = new PurchaseIdentifier();
        this.memberIdentifier = memberIdentifier;
        this.employeeIdentifier = employeeIdentifier;
        this.membershipIdentifier = membershipIdentifier;
        this.paymentType = paymentType;
        this.creditCardType = creditCardType;
        this.startDate = startDate;
    }

}
