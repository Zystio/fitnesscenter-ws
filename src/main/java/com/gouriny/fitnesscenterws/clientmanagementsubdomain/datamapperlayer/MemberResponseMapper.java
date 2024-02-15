package com.gouriny.fitnesscenterws.clientmanagementsubdomain.datamapperlayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Member;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberController;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberResponseModel;
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
public interface MemberResponseMapper {


    @Mapping(expression = "java(member.getMemberIdentifier().getMemberId())",
            target = "memberId")
    @Mapping(expression = "java(member.getAddress().getStreetAddress())", target = "streetAddress")
    @Mapping(expression = "java(member.getAddress().getCity())", target = "city")
    @Mapping(expression = "java(member.getAddress().getProvince())", target = "province")
    @Mapping(expression = "java(member.getAddress().getCountry())", target = "country")
    @Mapping(expression = "java(member.getAddress().getPostalCode())", target = "postalCode")
    MemberResponseModel entityToResponseModel(Member member);

    List<MemberResponseModel> entityListToResponseModelList(List<Member> members);

    @AfterMapping
    default void addLinks(@MappingTarget MemberResponseModel model, Member member){
        Link selfLink =
                linkTo(methodOn(MemberController.class)
                        .getMemberByMemberId(UUID.fromString(model.getMemberId())))
                        .withSelfRel();
        model.add(selfLink);
    }
}
