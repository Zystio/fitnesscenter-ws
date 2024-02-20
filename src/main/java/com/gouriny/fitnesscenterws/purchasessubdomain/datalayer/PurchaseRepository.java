package com.gouriny.fitnesscenterws.purchasessubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

        List<Purchase> findPurchasesByMemberIdentifier_MemberId(String memberId);
}
