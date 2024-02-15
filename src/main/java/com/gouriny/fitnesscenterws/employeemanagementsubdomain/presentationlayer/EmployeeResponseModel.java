package com.gouriny.fitnesscenterws.employeemanagementsubdomain.presentationlayer;

import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.PhoneNumber;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class EmployeeResponseModel extends RepresentationModel<EmployeeResponseModel> {
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
