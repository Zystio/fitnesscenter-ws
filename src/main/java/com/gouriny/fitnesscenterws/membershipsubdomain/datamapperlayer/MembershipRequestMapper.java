package com.gouriny.fitnesscenterws.membershipsubdomain.datamapperlayer;


import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.Membership;
import com.gouriny.fitnesscenterws.common.MembershipIdentifier;
import com.gouriny.fitnesscenterws.membershipsubdomain.presentationlayer.MembershipRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MembershipRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "membershipIdentifier")

    Membership requestModelToEntity(MembershipRequestModel membershipRequestModel, MembershipIdentifier membershipIdentifier);

}
