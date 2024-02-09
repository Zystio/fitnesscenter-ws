package com.gouriny.fitnesscenterws.clientmanagementsubdomain.businesslayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Address;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Client;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.ClientIdentifier;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.ClientRepository;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datamapperlayer.ClientRequestMapper;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datamapperlayer.ClientResponseMapper;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.ClientRequestModel;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.ClientResponseModel;
import com.gouriny.fitnesscenterws.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService{

    private final ClientRepository clientRepository;
    private final ClientResponseMapper clientResponseMapper;

    private final ClientRequestMapper clientRequestMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientResponseMapper clientResponseMapper, ClientRequestMapper clientRequestMapper) {
        this.clientRepository = clientRepository;
        this.clientResponseMapper = clientResponseMapper;
        this.clientRequestMapper = clientRequestMapper;
    }

    @Override
    public List<ClientResponseModel> getAllClients() {
        return clientResponseMapper.entityListToResponseModelList(clientRepository.findAll());
    }

    @Override
    public ClientResponseModel getClientByClientId(UUID clientId) {

        Client client = clientRepository.findClientByClientIdentifier_ClientId(clientId.toString());
        return clientResponseMapper.entityToResponseModel(client);
    }

    @Override
    public ClientResponseModel addClient(ClientRequestModel clientRequestModel) {
        Address address = new Address(clientRequestModel.getStreetAddress(), clientRequestModel.getCity(), clientRequestModel.getProvince(), clientRequestModel.getCountry(), clientRequestModel.getPostalCode());
//        address.setStreetAddress(clientRequestModel.getStreetAddress());
//        address.setCity(clientRequestModel.getCity());
//        address.setProvince(clientRequestModel.getProvince());
//        address.setCountry(clientRequestModel.getCountry());
//        address.setPostalCode(clientRequestModel.getPostalCode());


        Client client = clientRequestMapper.requestModelToEntity(clientRequestModel, new ClientIdentifier(), address);
        return clientResponseMapper.entityToResponseModel(clientRepository.save(client));
    }

    @Override
    public ClientResponseModel updateClient(ClientRequestModel clientRequestModel, UUID clientId) {
        //find if client exists
        Client existingClient = clientRepository.findClientByClientIdentifier_ClientId(clientId.toString());

        if (existingClient == null){
            throw new NotFoundException("No client found with ID: " + clientId); // later thrown an exception
        }

        Client client = clientRequestMapper.requestModelToEntity(clientRequestModel, existingClient.getClientIdentifier(), existingClient.getAddress());

        client.setId(existingClient.getId());

        return clientResponseMapper.entityToResponseModel(clientRepository.save(client));
    }

    @Override
    public void deleteClient(UUID clientId) {
        Client existingClient = clientRepository.findClientByClientIdentifier_ClientId(clientId.toString());

        if (existingClient == null){
            throw new NotFoundException("No client found with: " + clientId); // later thrown an exception
        }

        clientRepository.delete(existingClient);
    }
}
