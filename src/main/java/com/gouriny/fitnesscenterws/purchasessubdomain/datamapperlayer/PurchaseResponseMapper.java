package com.gouriny.fitnesscenterws.purchasessubdomain.datamapperlayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Member;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.Employee;
import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.Membership;
import com.gouriny.fitnesscenterws.purchasessubdomain.datalayer.Purchase;
import com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer.PurchaseResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseResponseMapper {

        @Mapping(expression = "java(purchase.getPurchaseIdentifier().getPurchaseId())",
                target = "purchaseId")


        @Mapping(expression = "java(purchase.getMemberIdentifier().getMemberId())", target = "memberId")
        @Mapping(expression = "java(member.getFirstName())", target = "memberFirstName")
        @Mapping(expression = "java(member.getLastName())", target = "memberLastName")

        @Mapping(expression = "java(purchase.getEmployeeIdentifier().getEmployeeId())", target = "employeeId")
        @Mapping(expression = "java(employee.getFirstName())", target = "employeeFirstName")
        @Mapping(expression = "java(employee.getLastName())", target = "employeeLastName")

        @Mapping(expression = "java(purchase.getMembershipIdentifier().getMembershipId())", target = "membershipId")
        @Mapping(expression = "java(membership.getMembershipType())", target = "membershipType")
        @Mapping(expression = "java(membership.getStatus())", target = "status")
        @Mapping(expression = "java(membership.getCardFee())", target = "cardFee")
        @Mapping(expression = "java(membership.getRegistrationFee())", target = "registrationFee")
        @Mapping(expression = "java(membership.getMonthlyFee())", target = "monthlyFee")



        PurchaseResponseModel entityToResponseModel(Purchase purchase, Member member, Employee employee, Membership membership);

//        List<PurchaseResponseModel> entityListToResponseModelList(List<Purchase> purchases);

}
