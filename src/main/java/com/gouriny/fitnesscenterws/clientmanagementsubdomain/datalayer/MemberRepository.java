package com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {


    Member findMemberByMemberIdentifier_MemberId(String memberId);
}
