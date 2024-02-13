package com.gouriny.fitnesscenterws.clientmanagementsubdomain.businesslayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberRequestModel;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberResponseModel;

import java.util.List;
import java.util.UUID;

public interface MemberService {

    List<MemberResponseModel> getAllMembers();

    MemberResponseModel getMemberByMemberId(UUID memberId);

    MemberResponseModel addMember(MemberRequestModel memberRequestModel);

    MemberResponseModel updateMember(MemberRequestModel memberRequestModel, UUID memberId);

    void deleteClient(UUID memberId);


}
