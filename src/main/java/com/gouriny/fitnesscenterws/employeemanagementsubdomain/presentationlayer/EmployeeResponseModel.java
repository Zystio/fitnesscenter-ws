package com.gouriny.fitnesscenterws.employeemanagementsubdomain.presentationlayer;

import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.PhoneNumber;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeResponseModel {
    String employeeId;
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
}
