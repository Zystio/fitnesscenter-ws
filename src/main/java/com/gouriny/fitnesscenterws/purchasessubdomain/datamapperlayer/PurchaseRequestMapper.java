package com.gouriny.fitnesscenterws.purchasessubdomain.datamapperlayer;

import com.gouriny.fitnesscenterws.common.EmployeeIdentifier;
import com.gouriny.fitnesscenterws.common.MemberIdentifier;
import com.gouriny.fitnesscenterws.common.MembershipIdentifier;
import com.gouriny.fitnesscenterws.purchasessubdomain.datalayer.Purchase;
import com.gouriny.fitnesscenterws.purchasessubdomain.datalayer.PurchaseIdentifier;
import com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer.PurchaseRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PurchaseRequestMapper {

    @Mapping(target = "id", ignore = true)


    Purchase requestModelToEntity(PurchaseRequestModel purchaseRequestModel, PurchaseIdentifier purchaseIdentifier, MemberIdentifier memberIdentifier,
                                  EmployeeIdentifier employeeIdentifier, MembershipIdentifier membershipIdentifier);


}
