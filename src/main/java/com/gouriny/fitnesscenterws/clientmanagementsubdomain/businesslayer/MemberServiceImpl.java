package com.gouriny.fitnesscenterws.clientmanagementsubdomain.businesslayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Address;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Member;
import com.gouriny.fitnesscenterws.common.MemberIdentifier;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.MemberRepository;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datamapperlayer.MemberRequestMapper;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datamapperlayer.MemberResponseMapper;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberRequestModel;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberResponseModel;
import com.gouriny.fitnesscenterws.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberResponseMapper memberResponseMapper;

    private final MemberRequestMapper memberRequestMapper;

    public MemberServiceImpl(MemberRepository memberRepository, MemberResponseMapper memberResponseMapper, MemberRequestMapper memberRequestMapper) {
        this.memberRepository = memberRepository;
        this.memberResponseMapper = memberResponseMapper;
        this.memberRequestMapper = memberRequestMapper;
    }

    @Override
    public List<MemberResponseModel> getAllMembers() {
        return memberResponseMapper.entityListToResponseModelList(memberRepository.findAll());
    }

    @Override
    public MemberResponseModel getMemberByMemberId(UUID memberId) {

        Member member = memberRepository.findMemberByMemberIdentifier_MemberId(memberId.toString());
        return memberResponseMapper.entityToResponseModel(member);
    }

    @Override
    public MemberResponseModel addMember(MemberRequestModel memberRequestModel) {
        Address address = new Address(memberRequestModel.getStreetAddress(), memberRequestModel.getCity(), memberRequestModel.getProvince(), memberRequestModel.getCountry(), memberRequestModel.getPostalCode());
//        address.setStreetAddress(clientRequestModel.getStreetAddress());
//        address.setCity(clientRequestModel.getCity());
//        address.setProvince(clientRequestModel.getProvince());
//        address.setCountry(clientRequestModel.getCountry());
//        address.setPostalCode(clientRequestModel.getPostalCode());


        Member member = memberRequestMapper.requestModelToEntity(memberRequestModel, new MemberIdentifier(), address);
        return memberResponseMapper.entityToResponseModel(memberRepository.save(member));
    }

    @Override
    public MemberResponseModel updateMember(MemberRequestModel memberRequestModel, UUID memberId) {
        //find if client exists
        Member existingMember = memberRepository.findMemberByMemberIdentifier_MemberId(memberId.toString());

        if (existingMember == null){
            throw new NotFoundException("No client found with ID: " + memberId); // later thrown an exception
        }

        Member member = memberRequestMapper.requestModelToEntity(memberRequestModel, existingMember.getMemberIdentifier(), existingMember.getAddress());

        member.setId(existingMember.getId());

        return memberResponseMapper.entityToResponseModel(memberRepository.save(member));
    }

    @Override
    public void deleteClient(UUID memberId) {
        Member existingMember = memberRepository.findMemberByMemberIdentifier_MemberId(memberId.toString());

        if (existingMember == null){
            throw new NotFoundException("No client found with: " + memberId); // later thrown an exception
        }

        memberRepository.delete(existingMember);
    }
}
