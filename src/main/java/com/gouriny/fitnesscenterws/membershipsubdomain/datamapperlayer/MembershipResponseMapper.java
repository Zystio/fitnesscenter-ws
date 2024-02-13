package com.gouriny.fitnesscenterws.membershipsubdomain.datamapperlayer;

import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.Membership;
import com.gouriny.fitnesscenterws.membershipsubdomain.presentationlayer.MembershipResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MembershipResponseMapper {


    @Mapping(expression = "java(membership.getMembershipIdentifier().getMembershipId())", target = "membershipId")

    MembershipResponseModel entityToResponseModel(Membership membership);
    List<MembershipResponseModel> entityListToResponseModelList(List<Membership> memberships);
}

