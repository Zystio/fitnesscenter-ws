package com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.PhoneNumber;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class MemberResponseModel extends RepresentationModel<MemberResponseModel> {
    String memberId;
    String firstName;
    String lastName;
    List<PhoneNumber> phoneNumbers;
    String emailAddress;
    String streetAddress;
    String city;
    String province;
    String country;
    String postalCode;
}
