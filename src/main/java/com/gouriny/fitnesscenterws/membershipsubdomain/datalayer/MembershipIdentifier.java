package com.gouriny.fitnesscenterws.membershipsubdomain.datalayer;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class MembershipIdentifier {
    private String membershipId;

    public MembershipIdentifier() {
        this.membershipId = UUID.randomUUID().toString();
    }

}
