package com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmployeeIdentifier_EmployeeId(String employeeId);
}
