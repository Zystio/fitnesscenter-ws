package com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer;

import com.gouriny.fitnesscenterws.purchasessubdomain.businesslayer.PurchaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/members/{memberId}/purchases")
public class MemberPurchaseController {

    private PurchaseService purchaseService;

    public MemberPurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping()
    public ResponseEntity<List<PurchaseResponseModel>> getAllPurchasesForMember (@PathVariable String memberId) {
        return ResponseEntity.ok().body(purchaseService.getAllPurchasesForMember(memberId));
    }
}
