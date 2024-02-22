package com.gouriny.fitnesscenterws.purchasessubdomain.datalayer;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class PurchaseIdentifier {

        private String purchaseId;

        public PurchaseIdentifier() {
            this.purchaseId = java.util.UUID.randomUUID().toString();
        }
        public PurchaseIdentifier(String purchaseId) {
            this.purchaseId = purchaseId;
        }


}
