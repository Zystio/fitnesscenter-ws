package com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Entity
@Table(name = "clients")
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //private id

    @Embedded
    private ClientIdentifier clientIdentifier; //public id

    private String firstName;
    private String lastName;
    private String emailAddress;

    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "client_phonenumbers", joinColumns = @JoinColumn(name = "client_id"))
    private List<PhoneNumber> phoneNumbers;

    public Client(){

    }

    public Client(String firstName, String lastName, String emailAddress, Address address, List<PhoneNumber> phoneNumbers) {
        this.clientIdentifier = new ClientIdentifier();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

}
