package com.gouriny.fitnesscenterws.membershipsubdomain.datalayer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "memberships")
@Data

public class Membership {

    @Id
    @GeneratedValue
    private Integer id;

    @Embedded
    private MembershipIdentifier membershipIdentifier;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Billing billing;





}
