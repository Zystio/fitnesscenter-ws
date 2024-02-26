package com.gouriny.fitnesscenterws.purchasessubdomain.businesslayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Member;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.MemberRepository;
import com.gouriny.fitnesscenterws.common.EmployeeIdentifier;
import com.gouriny.fitnesscenterws.common.MemberIdentifier;
import com.gouriny.fitnesscenterws.common.MembershipIdentifier;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.Employee;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.EmployeeRepository;
import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.Membership;
import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.MembershipRepository;
import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.Status;
import com.gouriny.fitnesscenterws.purchasessubdomain.datalayer.Purchase;
import com.gouriny.fitnesscenterws.purchasessubdomain.datalayer.PurchaseIdentifier;
import com.gouriny.fitnesscenterws.purchasessubdomain.datalayer.PurchaseRepository;
import com.gouriny.fitnesscenterws.purchasessubdomain.datamapperlayer.PurchaseRequestMapper;
import com.gouriny.fitnesscenterws.purchasessubdomain.datamapperlayer.PurchaseResponseMapper;
import com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer.PurchaseRequestModel;
import com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer.PurchaseResponseModel;
import com.gouriny.fitnesscenterws.utils.exceptions.InvalidInputException;
import com.gouriny.fitnesscenterws.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    private final MemberRepository memberRepository;

    private final EmployeeRepository employeeRepository;

    private final MembershipRepository membershipRepository;

    private final PurchaseRequestMapper purchaseRequestMapper;


    private final PurchaseResponseMapper purchaseResponseMapper;


    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, PurchaseResponseMapper purchaseResponseMapper, PurchaseRequestMapper purchaseRequestMapper, MemberRepository memberRepository, EmployeeRepository employeeRepository, MembershipRepository membershipRepository) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseResponseMapper = purchaseResponseMapper;
        this.memberRepository = memberRepository;
        this.employeeRepository = employeeRepository;
        this.membershipRepository = membershipRepository;
        this.purchaseRequestMapper = purchaseRequestMapper;
    }

    @Override
    public List<PurchaseResponseModel> getAllPurchasesForMember(String memberId) {
        Member member = memberRepository.findMemberByMemberIdentifier_MemberId(memberId);
        if (member == null) {
            throw new NotFoundException("MemberId provided is invalid " + memberId);
        }

        List<PurchaseResponseModel> purchaseResponseModelList = new ArrayList<>();
        List<Purchase> purchaseList = purchaseRepository.findPurchasesByMemberIdentifier_MemberId(memberId);

        purchaseList.forEach(purchase -> {
              Employee employee = employeeRepository.findByEmployeeIdentifier_EmployeeId(purchase.getEmployeeIdentifier().getEmployeeId());
                if (employee == null) {
                    throw new NotFoundException("EmployeeId provided is invalid " + purchase.getEmployeeIdentifier().getEmployeeId());
                }
                Membership membership = membershipRepository.findByMembershipIdentifier_MembershipId(purchase.getMembershipIdentifier().getMembershipId());
                if (membership == null) {
                    throw new NotFoundException("MembershipId provided is invalid " + purchase.getMembershipIdentifier().getMembershipId());
                }
                purchaseResponseModelList.add(purchaseResponseMapper.entityToResponseModel(purchase, member, employee, membership));
            });
        return purchaseResponseModelList;


    }

    @Override
    public PurchaseResponseModel getMemberPurchaseByPurchaseId(String memberId, String purchaseId) {

        Member member = memberRepository.findMemberByMemberIdentifier_MemberId(memberId);

        if (member == null) {
            throw new InvalidInputException("MemberId provided is invalid " + memberId);
        }

        Purchase purchase = purchaseRepository.findPurchaseByMemberIdentifier_MemberIdAndPurchaseIdentifier_PurchaseId(memberId, purchaseId);

        if (purchase == null) {
            throw new NotFoundException("PurchaseId provided is unknown " + purchaseId);
        }

        Employee employee = employeeRepository.findByEmployeeIdentifier_EmployeeId(purchase.getEmployeeIdentifier().getEmployeeId());
        if (employee == null) {
            throw new NotFoundException("EmployeeId provided is invalid " + purchase.getEmployeeIdentifier().getEmployeeId());
        }

        Membership membership = membershipRepository.findByMembershipIdentifier_MembershipId(purchase.getMembershipIdentifier().getMembershipId());
        if (membership == null) {
            throw new NotFoundException("MembershipId provided is invalid " + purchase.getMembershipIdentifier().getMembershipId());
        }

        return purchaseResponseMapper.entityToResponseModel(purchase, member, employee, membership);

    }

    @Override
    public PurchaseResponseModel addPurchaseToMember(PurchaseRequestModel purchaseRequestModel, String memberId){

        //verify if member exists
        Member member = memberRepository.findMemberByMemberIdentifier_MemberId(memberId);
        if (member == null) {
            throw new NotFoundException("MemberId provided is invalid " + memberId);
        }
        //verify if employee exists
        Employee employee = employeeRepository.findByEmployeeIdentifier_EmployeeId(purchaseRequestModel.getEmployeeId());
        if (employee == null) {
            throw new NotFoundException("EmployeeId provided is invalid " + purchaseRequestModel.getEmployeeId());
        }
        //verify if membership exists
        Membership membership = membershipRepository.findByMembershipIdentifier_MembershipId(purchaseRequestModel.getMembershipId());
        if (membership == null) {
            throw new NotFoundException("MembershipId provided is invalid " + purchaseRequestModel.getMembershipId());
        }

        Purchase purchase = purchaseRequestMapper.requestModelToEntity(purchaseRequestModel, new PurchaseIdentifier(),
                member.getMemberIdentifier(), employee.getEmployeeIdentifier(), membership.getMembershipIdentifier());

        Purchase savedPurchase = purchaseRepository.save(purchase);
        return purchaseResponseMapper.entityToResponseModel(savedPurchase, member, employee, membership);
    }

    @Override
    public PurchaseResponseModel updateMemberPurchase(PurchaseRequestModel purchaseRequestModel, String memberId, String purchaseId) {
        Purchase existingPurchase = purchaseRepository.findPurchaseByMemberIdentifier_MemberIdAndPurchaseIdentifier_PurchaseId(memberId, purchaseId);
        if (existingPurchase == null) {
            throw new NotFoundException("PurchaseId provided is unknown " + purchaseId);
        }

        Member existingMember = memberRepository.findMemberByMemberIdentifier_MemberId(memberId);
        if (existingMember == null) {
            throw new NotFoundException("MemberId provided is invalid " + memberId);
        }
        //verify if employee exists
        Employee existingEmployee = employeeRepository.findByEmployeeIdentifier_EmployeeId(purchaseRequestModel.getEmployeeId());
        if (existingEmployee == null) {
            throw new NotFoundException("EmployeeId provided is invalid " + purchaseRequestModel.getEmployeeId());
        }
        //verify if membership exists
        Membership existingMembership = membershipRepository.findByMembershipIdentifier_MembershipId(purchaseRequestModel.getMembershipId());
        if (existingMembership == null) {
            throw new NotFoundException("MembershipId provided is invalid " + purchaseRequestModel.getMembershipId());
        }

        Purchase purchase = purchaseRequestMapper.requestModelToEntity(purchaseRequestModel, existingPurchase.getPurchaseIdentifier(),
                existingMember.getMemberIdentifier(), existingEmployee.getEmployeeIdentifier(), existingMembership.getMembershipIdentifier());

        purchase.setId(existingPurchase.getId());

        return purchaseResponseMapper.entityToResponseModel(purchaseRepository.save(purchase), existingMember, existingEmployee, existingMembership);





    }


    //we won't be removing the purchase from the customer
    //instead, we will be setting the membership status to expired
    //this is because we want to keep the purchase history
    //and also, we want to keep the membership details, in case they want to renew their membership
    @Override
    public void removePurchaseFromCustomer(String memberId, String purchaseId) {

        Member member = memberRepository.findMemberByMemberIdentifier_MemberId(memberId);
        if (member == null) {
            throw new NotFoundException("MemberId provided is invalid" + memberId);
        }

        Purchase purchase = purchaseRepository.findPurchaseByMemberIdentifier_MemberIdAndPurchaseIdentifier_PurchaseId(memberId, purchaseId);
        if (purchase == null) {
            throw new NotFoundException("PurchaseId provided is unknown " + purchaseId);
        }

        Employee employee = employeeRepository.findByEmployeeIdentifier_EmployeeId(purchase.getEmployeeIdentifier().getEmployeeId());
        if (employee == null) {
            throw new NotFoundException("EmployeeId provided is invalid " + purchase.getEmployeeIdentifier().getEmployeeId());
        }

        Membership membership = membershipRepository.findByMembershipIdentifier_MembershipId(purchase.getMembershipIdentifier().getMembershipId());
        if (membership == null) {
            throw new NotFoundException("MembershipId provided is invalid " + purchase.getMembershipIdentifier().getMembershipId());
        }


        membership.setStatus(Status.valueOf("Expired"));
        membershipRepository.save(membership);

    }


}
