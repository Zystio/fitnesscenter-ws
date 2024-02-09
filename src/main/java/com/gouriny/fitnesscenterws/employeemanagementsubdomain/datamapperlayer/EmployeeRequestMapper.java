package com.gouriny.fitnesscenterws.employeemanagementsubdomain.datamapperlayer;

import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.Address;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.Employee;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.EmployeeIdentifier;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.presentationlayer.EmployeeRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employeeIdentifier")
    @Mapping(target = "address")
    Employee requestModelToEntity(EmployeeRequestModel employeeRequestModel, EmployeeIdentifier employeeIdentifier, Address address);
}
