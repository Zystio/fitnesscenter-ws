package com.gouriny.fitnesscenterws.membershipsubdomain.datalayer;

import com.gouriny.fitnesscenterws.common.MembershipIdentifier;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "memberships")
@Data
@Getter
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

    private Double cardFee;
    private Double registrationFee;
    private Double monthlyFee;

    public Membership(){

    }

    public Membership(Type membershipType, Status status, BillingType billingType, Double cardFee, Double registrationFee, Double monthlyFee) {
        this.membershipIdentifier = new MembershipIdentifier();
        this.membershipType = membershipType;
        this.status = status;
        this.billingType = billingType;
        this.cardFee = cardFee;
        this.registrationFee = registrationFee;
        this.monthlyFee = monthlyFee;
    }





}
