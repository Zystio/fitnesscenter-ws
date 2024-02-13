package com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Entity
@Table(name = "members")
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //private id

    @Embedded
    private MemberIdentifier memberIdentifier; //public id

    private String firstName;
    private String lastName;
    private String emailAddress;

    @Embedded
    private Address address;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "member_phonenumbers", joinColumns = @JoinColumn(name = "member_id"))
    private List<PhoneNumber> phoneNumbers;

    public Member(){

    }

    public Member(String firstName, String lastName, String emailAddress, Address address, List<PhoneNumber> phoneNumbers) {
        this.memberIdentifier = new MemberIdentifier();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
    }

}
