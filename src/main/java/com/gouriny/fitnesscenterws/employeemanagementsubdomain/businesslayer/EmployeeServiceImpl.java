package com.gouriny.fitnesscenterws.employeemanagementsubdomain.businesslayer;

import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.Address;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.Employee;
import com.gouriny.fitnesscenterws.common.EmployeeIdentifier;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.EmployeeRepository;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datamapperlayer.EmployeeRequestMapper;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datamapperlayer.EmployeeResponseMapper;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.presentationlayer.EmployeeRequestModel;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.presentationlayer.EmployeeResponseModel;
import com.gouriny.fitnesscenterws.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeResponseMapper employeeResponseMapper;
    private final EmployeeRequestMapper employeeRequestMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeResponseMapper employeeResponseMapper, EmployeeRequestMapper employeeRequestMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeResponseMapper = employeeResponseMapper;
        this.employeeRequestMapper = employeeRequestMapper;
    }

    @Override
    public List<EmployeeResponseModel> getAllEmployees() {
        return employeeResponseMapper.entityListToResponseModelList(employeeRepository.findAll());
    }

    @Override
    public EmployeeResponseModel getEmployeeByEmployeeId(UUID employeeId) {
        Employee employee = employeeRepository.findByEmployeeIdentifier_EmployeeId(employeeId.toString());
        return employeeResponseMapper.entityToResponseModel(employee);
    }

    @Override
    public EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel) {
        Address address = new Address(employeeRequestModel.getStreetAddress(), employeeRequestModel.getCity(), employeeRequestModel.getProvince(), employeeRequestModel.getCountry(), employeeRequestModel.getPostalCode());


        Employee employee = employeeRequestMapper.requestModelToEntity(employeeRequestModel, new EmployeeIdentifier(), address);
        return employeeResponseMapper.entityToResponseModel(employeeRepository.save(employee));


    }

    @Override
    public EmployeeResponseModel updateEmployee(EmployeeRequestModel employeeRequestModel, UUID employeeId) {
        Employee existingEmployee = employeeRepository.findByEmployeeIdentifier_EmployeeId(employeeId.toString());
        if (existingEmployee == null) {
            throw new NotFoundException("No employee found with ID: " + employeeId);
        }

        Employee employee = employeeRequestMapper.requestModelToEntity(employeeRequestModel, existingEmployee.getEmployeeIdentifier(), existingEmployee.getAddress());
        employee.setId(existingEmployee.getId());
        return employeeResponseMapper.entityToResponseModel(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(UUID employeeId) {

        Employee existingEmployee = employeeRepository.findByEmployeeIdentifier_EmployeeId(employeeId.toString());
        if (existingEmployee == null) {
            throw new NotFoundException("No employee found with: " + employeeId);
        }
        employeeRepository.delete(existingEmployee);
    }

}
