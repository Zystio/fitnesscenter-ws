package com.gouriny.fitnesscenterws.clientmanagementsubdomain.datamapperlayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Address;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Client;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.ClientIdentifier;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.ClientRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "clientIdentifier")
    @Mapping(target = "address")
    Client requestModelToEntity(ClientRequestModel clientRequestModel, ClientIdentifier clientIdentifier, Address address);
}
