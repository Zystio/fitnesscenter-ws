package com.gouriny.fitnesscenterws.clientmanagementsubdomain.datamapperlayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Member;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

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
}
