package com.gouriny.fitnesscenterws.membershipsubdomain.businesslayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberRequestModel;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberResponseModel;
import com.gouriny.fitnesscenterws.membershipsubdomain.presentationlayer.MembershipRequestModel;
import com.gouriny.fitnesscenterws.membershipsubdomain.presentationlayer.MembershipResponseModel;

import java.util.List;
import java.util.UUID;

public interface MembershipService {

    List<MembershipResponseModel> getAllMemberships();
    MembershipResponseModel getMembershipByMembershipId(UUID membershipId);
    MembershipResponseModel addMembership(MembershipRequestModel membershipRequestModel);
    MembershipResponseModel updateMembership(MembershipRequestModel membershipRequestModel, UUID membershipId);
    void deleteMembership(UUID membershipId);


//    List<MemberResponseModel> getAllMembers();
//
//    MemberResponseModel getMemberByMemberId(UUID memberId);
//
//    MemberResponseModel addMember(MemberRequestModel memberRequestModel);
//
//    MemberResponseModel updateMember(MemberRequestModel memberRequestModel, UUID memberId);
//
//    void deleteClient(UUID memberId);

}
