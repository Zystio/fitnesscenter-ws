package com.gouriny.fitnesscenterws.employeemanagementsubdomain.businesslayer;

import com.gouriny.fitnesscenterws.employeemanagementsubdomain.presentationlayer.EmployeeRequestModel;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.presentationlayer.EmployeeResponseModel;

import java.util.List;
import java.util.UUID;


public interface EmployeeService {

    List<EmployeeResponseModel> getAllEmployees();

    EmployeeResponseModel getEmployeeByEmployeeId(UUID employeeId);

    EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel);

    EmployeeResponseModel updateEmployee(EmployeeRequestModel employeeRequestModel, UUID employeeId);

    void deleteEmployee(UUID employeeId);
}
