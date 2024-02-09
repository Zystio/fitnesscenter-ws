package com.gouriny.fitnesscenterws.employeemanagementsubdomain.datamapperlayer;

import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.Employee;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.presentationlayer.EmployeeResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeResponseMapper {

    @Mapping(expression = "java(employee.getEmployeeIdentifier().getEmployeeId())",
            target = "employeeId")
    @Mapping(expression = "java(employee.getAddress().getStreetAddress())", target = "streetAddress")
    @Mapping(expression = "java(employee.getAddress().getCity())", target = "city")
    @Mapping(expression = "java(employee.getAddress().getProvince())", target = "province")
    @Mapping(expression = "java(employee.getAddress().getCountry())", target = "country")
    @Mapping(expression = "java(employee.getAddress().getPostalCode())", target = "postalCode")
    EmployeeResponseModel entityToResponseModel(Employee employee);

    List<EmployeeResponseModel> entityListToResponseModelList(List<Employee> employees);

}

//@Mapper(componentModel = "spring")
//public interface ClientResponseMapper {
//
//
//    @Mapping(expression = "java(client.getClientIdentifier().getClientId())",
//            target = "clientId")
//    @Mapping(expression = "java(client.getAddress().getStreetAddress())", target = "streetAddress")
//    @Mapping(expression = "java(client.getAddress().getCity())", target = "city")
//    @Mapping(expression = "java(client.getAddress().getProvince())", target = "province")
//    @Mapping(expression = "java(client.getAddress().getCountry())", target = "country")
//    @Mapping(expression = "java(client.getAddress().getPostalCode())", target = "postalCode")
//    ClientResponseModel entityToResponseModel(Client client);
//
//    List<ClientResponseModel> entityListToResponseModelList(List<Client> clients);
//}