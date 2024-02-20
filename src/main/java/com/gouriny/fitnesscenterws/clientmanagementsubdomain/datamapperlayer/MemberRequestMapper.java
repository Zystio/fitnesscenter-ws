package com.gouriny.fitnesscenterws.clientmanagementsubdomain.datamapperlayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Address;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Member;
import com.gouriny.fitnesscenterws.common.MemberIdentifier;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "memberIdentifier")
    @Mapping(target = "address")
    Member requestModelToEntity(MemberRequestModel memberRequestModel, MemberIdentifier memberIdentifier, Address address);
}
