package com.gouriny.fitnesscenterws.employeemanagementsubdomain.presentationlayer;


import com.gouriny.fitnesscenterws.employeemanagementsubdomain.businesslayer.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<EmployeeResponseModel>> getAllEmployees(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping(value = "/{employeeId}", produces = "application/json")
    public ResponseEntity<EmployeeResponseModel> getEmployeeByEmployeeId(@PathVariable UUID employeeId){
        return ResponseEntity.ok().body(employeeService.getEmployeeByEmployeeId(employeeId));
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<EmployeeResponseModel> addEmployee(@RequestBody EmployeeRequestModel employeeRequestModel){
        EmployeeResponseModel employeeResponseModel = employeeService.addEmployee(employeeRequestModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponseModel);
    }

    @PutMapping(value = "/{employeeId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity <EmployeeResponseModel> updateEmployee(@RequestBody EmployeeRequestModel employeeRequestModel, @PathVariable UUID employeeId){
        EmployeeResponseModel employeeResponseModel = employeeService.updateEmployee(employeeRequestModel, employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponseModel);
    }

    @DeleteMapping(value = "/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }
//    ublic ClientController(ClientService clientService) {
//        this.clientService = clientService;
//    }
//
//    @GetMapping()
//    public ResponseEntity<List<ClientResponseModel>> getAllClients(){
//        return ResponseEntity.ok().body(clientService.getAllClients());
//    }
//
//    @GetMapping("/{clientId}")
//    public ResponseEntity<ClientResponseModel> getClientByClientId(@PathVariable UUID clientId){
//        return ResponseEntity.ok().body(clientService.getClientByClientId(clientId));
//    }
//
//    @PostMapping()
//    public ResponseEntity<ClientResponseModel> addClient(@RequestBody ClientRequestModel clientRequestModel){
//        ClientResponseModel clientResponseModel = clientService.addClient(clientRequestModel);
//        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponseModel);
//    }
//
//    @PutMapping("/{clientId}")
//    public ResponseEntity <ClientResponseModel> updateClient(@RequestBody ClientRequestModel clientRequestModel, @PathVariable UUID clientId){
//        ClientResponseModel clientResponseModel = clientService.updateClient(clientRequestModel, clientId);
//        return ResponseEntity.status(HttpStatus.OK).body(clientResponseModel);
//    }
//
//    @DeleteMapping("/{clientId}")
//    public ResponseEntity<Void> deleteClient(@PathVariable UUID clientId){
//        clientService.deleteClient(clientId);
//        return ResponseEntity.noContent().build();
//    }

}
