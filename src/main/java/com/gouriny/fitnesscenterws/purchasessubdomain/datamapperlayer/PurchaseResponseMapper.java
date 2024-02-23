package com.gouriny.fitnesscenterws.purchasessubdomain.datamapperlayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Member;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberController;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.Employee;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.presentationlayer.EmployeeController;
import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.Membership;
import com.gouriny.fitnesscenterws.membershipsubdomain.presentationlayer.MembershipController;
import com.gouriny.fitnesscenterws.purchasessubdomain.datalayer.Purchase;
import com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer.MemberPurchaseController;
import com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer.PurchaseResponseModel;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.hateoas.Link;

import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

        @Mapping(expression = "java(membership.getInitialFees().getCardFee())", target = "cardFee")
        @Mapping(expression = "java(membership.getInitialFees().getRegistrationFee())", target = "registrationFee")

        @Mapping(expression = "java(membership.getNextPayment().getPayment())", target = "payment")
        @Mapping(expression = "java(membership.getNextPayment().getPaymentDueDate())", target = "paymentDueDate")



        PurchaseResponseModel entityToResponseModel(Purchase purchase, Member member, Employee employee, Membership membership);

        @AfterMapping
        default void addLinks(@MappingTarget PurchaseResponseModel model, Purchase purchase, Member member, Employee employee, Membership membership) {

                //self link
                Link selfLink = linkTo(methodOn(MemberPurchaseController.class)
                        .getPurchaseForMemberByPurchaseId(model.getMemberId(),model.getPurchaseId())).
                        withSelfRel();
                model.add(selfLink);

                //all purchases for member
                Link purchasesLink = linkTo(methodOn(MemberPurchaseController.class)
                        .getAllPurchasesForMember(model.getMemberId()))
                        .withRel("allPurchases");
                model.add(purchasesLink);

                //member link
                Link memberLink = linkTo(methodOn(MemberController.class)
                        .getMemberByMemberId(UUID.fromString(model.getMemberId())))
                        .withRel("member");
                model.add(memberLink);

                //employee link
                Link employeeLink = linkTo(methodOn(EmployeeController.class)
                        .getEmployeeByEmployeeId(UUID.fromString(model.getEmployeeId())))
                        .withRel("employee");
                model.add(employeeLink);

                //membership link
                Link membershipLink = linkTo(methodOn(MembershipController.class)
                        .getMembershipByMembershipId(UUID.fromString(model.getMembershipId())))
                        .withRel("membership");
                model.add(membershipLink);



        }

//        List<PurchaseResponseModel> entityListToResponseModelList(List<Purchase> purchases);

}
