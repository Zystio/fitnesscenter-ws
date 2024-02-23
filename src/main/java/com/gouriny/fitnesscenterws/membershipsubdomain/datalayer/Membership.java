package com.gouriny.fitnesscenterws.membershipsubdomain.datalayer;

import com.gouriny.fitnesscenterws.common.MembershipIdentifier;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "memberships")
@Data
@Getter
@NoArgsConstructor
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private MembershipIdentifier membershipIdentifier;

    @Enumerated(EnumType.STRING)
    private Type membershipType;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private BillingType billingType;

    @Embedded
    private InitialFees initialFees;
//    private Double cardFee;
//    private Double registrationFee;

    @Embedded
    private NextPayment nextPayment;
//    private Double monthlyFee;
//    private String paymentDueDate;

    public Membership(String membershipId){

    }

    public Membership(Type membershipType, Status status, BillingType billingType, InitialFees initialFees, NextPayment nextPayment) {
        this.membershipIdentifier = new MembershipIdentifier();
        this.membershipType = membershipType;
        this.status = status;
        this.billingType = billingType;
        this.initialFees = initialFees;
        this.nextPayment = nextPayment;
//        this.cardFee = cardFee;
//        this.registrationFee = registrationFee;
//        this.monthlyFee = monthlyFee;
    }





}
