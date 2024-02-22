package com.gouriny.fitnesscenterws.purchasessubdomain.businesslayer;

import com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer.PurchaseRequestModel;
import com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer.PurchaseResponseModel;

import java.util.List;
import java.util.UUID;

public interface PurchaseService {

    List<PurchaseResponseModel> getAllPurchasesForMember(String memberId);

    PurchaseResponseModel getMemberPurchaseByPurchaseId(String memberId, String purchaseId);

    PurchaseResponseModel addPurchaseToMember(PurchaseRequestModel purchaseRequestModel, String memberId);

    PurchaseResponseModel updateMemberPurchase(PurchaseRequestModel purchaseRequestModel, String memberId, String purchaseId);

    void removePurchaseFromCustomer(String memberId, String purchaseId);

}
