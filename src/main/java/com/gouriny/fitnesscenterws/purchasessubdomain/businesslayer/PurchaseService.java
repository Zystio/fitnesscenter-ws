package com.gouriny.fitnesscenterws.purchasessubdomain.businesslayer;

import com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer.PurchaseRequestModel;
import com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer.PurchaseResponseModel;

import java.util.List;
import java.util.UUID;

public interface PurchaseService {

    List<PurchaseResponseModel> getAllPurchasesForMember(String memberId);

}
