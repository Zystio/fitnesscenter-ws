package com.gouriny.fitnesscenterws.clientmanagementsubdomain.businesslayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.ClientRequestModel;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.ClientResponseModel;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    List<ClientResponseModel> getAllClients();

    ClientResponseModel getClientByClientId(UUID clientId);

    ClientResponseModel addClient(ClientRequestModel clientRequestModel);

    ClientResponseModel updateClient(ClientRequestModel clientRequestModel, UUID clientId);

    void deleteClient(UUID clientId);


}
