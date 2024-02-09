package com.gouriny.fitnesscenterws.employeemanagementsubdomain.presentationlayer;

import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.PhoneNumber;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.Department;
import lombok.*;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeRequestModel {

    String firstName;
    String lastName;
    List<PhoneNumber> phoneNumbers;
    String emailAddress;
    String salary;
    String commissionRate;
    String streetAddress;
    String city;
    String province;
    String country;
    String postalCode;
    Department department;
}
//    @Value
//    @Builder
//    @AllArgsConstructor(access = AccessLevel.PRIVATE)
//    public class ClientRequestModel {
//        String firstName;
//        String lastName;
//        List<PhoneNumber> phoneNumbers;
//        String emailAddress;
//        String streetAddress;
//        String city;
//        String province;
//        String country;
//        String postalCode;
//    }

