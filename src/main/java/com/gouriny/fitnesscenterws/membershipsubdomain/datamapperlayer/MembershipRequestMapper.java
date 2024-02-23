package com.gouriny.fitnesscenterws.membershipsubdomain.datamapperlayer;


import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.InitialFees;
import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.Membership;
import com.gouriny.fitnesscenterws.common.MembershipIdentifier;
import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.NextPayment;
import com.gouriny.fitnesscenterws.membershipsubdomain.presentationlayer.MembershipRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MembershipRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "membershipIdentifier")
    @Mapping(target = "initialFees")
    @Mapping(target = "nextPayment")
    Membership requestModelToEntity(MembershipRequestModel membershipRequestModel, MembershipIdentifier membershipIdentifier, InitialFees initialFees, NextPayment nextPayment);

}
