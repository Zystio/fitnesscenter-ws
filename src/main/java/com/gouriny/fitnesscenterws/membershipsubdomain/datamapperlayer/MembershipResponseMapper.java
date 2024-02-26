package com.gouriny.fitnesscenterws.membershipsubdomain.datamapperlayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Member;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberController;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberResponseModel;
import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.Membership;
import com.gouriny.fitnesscenterws.membershipsubdomain.presentationlayer.MembershipController;
import com.gouriny.fitnesscenterws.membershipsubdomain.presentationlayer.MembershipResponseModel;
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
public interface MembershipResponseMapper {


    @Mapping(expression = "java(membership.getMembershipIdentifier().getMembershipId())", target = "membershipId")

    @Mapping(expression = "java(membership.getInitialFees().getCardFee())", target = "cardFee")
    @Mapping(expression = "java(membership.getInitialFees().getRegistrationFee())", target = "registrationFee")

    @Mapping(expression = "java(membership.getNextPayment().getPayment())", target = "payment")
    @Mapping(expression = "java(membership.getNextPayment().getPaymentDueDate())", target = "paymentDueDate")

    MembershipResponseModel entityToResponseModel(Membership membership);
    List<MembershipResponseModel> entityListToResponseModelList(List<Membership> memberships);

    @AfterMapping
    default void addLinks(@MappingTarget MembershipResponseModel model, Membership membership){
        Link selfLink =
                linkTo(methodOn(MembershipController.class)
                        .getMembershipByMembershipId(UUID.fromString(model.getMembershipId())))
                        .withSelfRel();
        model.add(selfLink);

        Link allMembershipsLink =
                linkTo(methodOn(MembershipController.class)
                        .getAllMemberships())
                        .withRel("allMemberships");
        model.add(allMembershipsLink);
    }
}

