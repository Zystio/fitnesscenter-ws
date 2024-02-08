package com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.PhoneNumber;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClientResponseModel {
    String clientId;
    //TODO ADD MEMBERSHIPID
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
