package com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer;


import com.gouriny.fitnesscenterws.clientmanagementsubdomain.businesslayer.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public ResponseEntity<List<ClientResponseModel>> getAllClients(){
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientResponseModel> getClientByClientId(@PathVariable UUID clientId){
        return ResponseEntity.ok().body(clientService.getClientByClientId(clientId));
    }

    @PostMapping()
    public ResponseEntity<ClientResponseModel> addClient(@RequestBody ClientRequestModel clientRequestModel){
        ClientResponseModel clientResponseModel = clientService.addClient(clientRequestModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponseModel);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity <ClientResponseModel> updateClient(@RequestBody ClientRequestModel clientRequestModel, @PathVariable UUID clientId){
        ClientResponseModel clientResponseModel = clientService.updateClient(clientRequestModel, clientId);
        return ResponseEntity.status(HttpStatus.OK).body(clientResponseModel);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable UUID clientId){
        clientService.deleteClient(clientId);
        return ResponseEntity.noContent().build();
    }



}
