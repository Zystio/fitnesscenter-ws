package com.gouriny.fitnesscenterws.membershipsubdomain.businesslayer;

import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.Membership;
import com.gouriny.fitnesscenterws.common.MembershipIdentifier;
import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.MembershipRepository;
import com.gouriny.fitnesscenterws.membershipsubdomain.datamapperlayer.MembershipRequestMapper;
import com.gouriny.fitnesscenterws.membershipsubdomain.datamapperlayer.MembershipResponseMapper;
import com.gouriny.fitnesscenterws.membershipsubdomain.presentationlayer.MembershipRequestModel;
import com.gouriny.fitnesscenterws.membershipsubdomain.presentationlayer.MembershipResponseModel;
import com.gouriny.fitnesscenterws.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MembershipServiceImpl implements MembershipService{

    private MembershipRepository membershipRepository;
    private MembershipResponseMapper membershipResponseMapper;
    private MembershipRequestMapper membershipRequestMapper;

    public MembershipServiceImpl(MembershipRepository membershipRepository, MembershipResponseMapper membershipResponseMapper, MembershipRequestMapper membershipRequestMapper) {
        this.membershipRepository = membershipRepository;
        this.membershipResponseMapper = membershipResponseMapper;
        this.membershipRequestMapper = membershipRequestMapper;
    }
    @Override
    public List<MembershipResponseModel> getAllMemberships() {
        return membershipResponseMapper.entityListToResponseModelList(membershipRepository.findAll());
    }

    @Override
    public MembershipResponseModel getMembershipByMembershipId(UUID membershipId) {
        Membership membership = membershipRepository.findByMembershipIdentifier_MembershipId(membershipId.toString());
        return membershipResponseMapper.entityToResponseModel(membership);
    }
    @Override
    public MembershipResponseModel addMembership(MembershipRequestModel membershipRequestModel) {
        Membership membership = membershipRequestMapper.requestModelToEntity(membershipRequestModel, new MembershipIdentifier());
        return membershipResponseMapper.entityToResponseModel(membershipRepository.save(membership));
    }

    @Override
    public MembershipResponseModel updateMembership(MembershipRequestModel membershipRequestModel, UUID membershipId) {
        Membership existingMembership = membershipRepository.findByMembershipIdentifier_MembershipId(membershipId.toString());

        if (existingMembership == null){
            throw new NotFoundException("No membership found with ID: " + membershipId); // later thrown an exception
        }
        Membership membership = membershipRequestMapper.requestModelToEntity(membershipRequestModel, existingMembership.getMembershipIdentifier());
        membership.setId(existingMembership.getId());

        return membershipResponseMapper.entityToResponseModel(membershipRepository.save(membership));
    }

    @Override
    public void deleteMembership(UUID membershipId) {
        Membership existingMembership = membershipRepository.findByMembershipIdentifier_MembershipId(membershipId.toString());

        if (existingMembership == null){
            throw new NotFoundException("No membership found with: " + membershipId); // later thrown an exception
        }
        membershipRepository.delete(existingMembership);
    }

}
