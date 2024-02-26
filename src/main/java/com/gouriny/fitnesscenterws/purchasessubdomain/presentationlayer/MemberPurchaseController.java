package com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer;

import com.gouriny.fitnesscenterws.purchasessubdomain.businesslayer.PurchaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/members/{memberId}/purchases")
public class MemberPurchaseController {

    private PurchaseService purchaseService;

    public MemberPurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<PurchaseResponseModel>> getAllPurchasesForMember (@PathVariable String memberId) {
        return ResponseEntity.ok().body(purchaseService.getAllPurchasesForMember(memberId));
    }

    @GetMapping(value ="/{purchaseId}", produces = "application/json")
    public ResponseEntity<PurchaseResponseModel> getPurchaseForMemberByPurchaseId (@PathVariable String memberId, @PathVariable String purchaseId) {
        return ResponseEntity.ok().body(purchaseService.getMemberPurchaseByPurchaseId(memberId, purchaseId));
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PurchaseResponseModel> addPurchaseToMember (@RequestBody PurchaseRequestModel purchaseRequestModel, @PathVariable String memberId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseService.addPurchaseToMember(purchaseRequestModel, memberId));
    }

    @PutMapping(value ="/{purchaseId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PurchaseResponseModel> updateMemberPurchase (@RequestBody PurchaseRequestModel purchaseRequestModel, @PathVariable String memberId, @PathVariable String purchaseId) {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.updateMemberPurchase(purchaseRequestModel, memberId, purchaseId));
    }

    @DeleteMapping(value = "/{purchaseId}")
    public ResponseEntity<Void> removePurchaseFromCustomer (@PathVariable String memberId, @PathVariable String purchaseId) {
        purchaseService.removePurchaseFromCustomer(memberId, purchaseId);
        return ResponseEntity.noContent().build();
    }
}
