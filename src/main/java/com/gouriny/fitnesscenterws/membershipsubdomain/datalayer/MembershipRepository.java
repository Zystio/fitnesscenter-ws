package com.gouriny.fitnesscenterws.membershipsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, Integer> {

    Membership findByMembershipIdentifier_MembershipId(String membershipId);
}
