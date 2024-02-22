package com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer;

import com.gouriny.fitnesscenterws.common.EmployeeIdentifier;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="employees")
@Getter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //private identifier

    @Embedded
    private EmployeeIdentifier employeeIdentifier; //public identifier

    private String firstName;
    private String lastName;
    private String emailAddress;

    private Double salary;
    private Double commissionRate;

    @Enumerated(EnumType.STRING)
    private Department department;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "employee_phonenumbers", joinColumns = @JoinColumn(name = "employee_id"))
    private List<PhoneNumber> phoneNumbers; // ask teacher if its necessary to create two classes for phone number and address

    @Embedded
    private Address address;


    public Employee(String employeeId) {

    }



    public Employee(String firstName, String lastName, Address address, String emailAddress, Double salary, Double commissionRate, Department department, List<PhoneNumber> phoneNumbers) {
        this.employeeIdentifier = new EmployeeIdentifier();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.salary = salary;
        this.commissionRate = commissionRate;
        this.department = department;
        this.phoneNumbers = phoneNumbers;
    }
}
