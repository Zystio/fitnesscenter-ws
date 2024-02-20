package com.gouriny.fitnesscenterws.purchasessubdomain.businesslayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.Member;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer.MemberRepository;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.Employee;
import com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer.EmployeeRepository;
import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.Membership;
import com.gouriny.fitnesscenterws.membershipsubdomain.datalayer.MembershipRepository;
import com.gouriny.fitnesscenterws.purchasessubdomain.datalayer.Purchase;
import com.gouriny.fitnesscenterws.purchasessubdomain.datalayer.PurchaseRepository;
import com.gouriny.fitnesscenterws.purchasessubdomain.datamapperlayer.PurchaseRequestMapper;
import com.gouriny.fitnesscenterws.purchasessubdomain.datamapperlayer.PurchaseResponseMapper;
import com.gouriny.fitnesscenterws.purchasessubdomain.presentationlayer.PurchaseResponseModel;
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



    private final PurchaseResponseMapper purchaseResponseMapper;


    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, PurchaseResponseMapper purchaseResponseMapper, PurchaseRequestMapper purchaseRequestMapper, MemberRepository memberRepository, EmployeeRepository employeeRepository, MembershipRepository membershipRepository) {
        this.purchaseRepository = purchaseRepository;
        this.purchaseResponseMapper = purchaseResponseMapper;
        this.memberRepository = memberRepository;
        this.employeeRepository = employeeRepository;
        this.membershipRepository = membershipRepository;
    }

    @Override
    public List<PurchaseResponseModel> getAllPurchasesForMember(String memberId) {
        Member member = memberRepository.findMemberByMemberIdentifier_MemberId(memberId);
        if (member == null) {
            throw new NotFoundException("MemberId provided is invalid" + memberId);
        }

        List<PurchaseResponseModel> purchaseResponseModelList = new ArrayList<>();
        List<Purchase> purchaseList = purchaseRepository.findPurchasesByMemberIdentifier_MemberId(memberId);

        purchaseList.forEach(purchase -> {
              Employee employee = employeeRepository.findByEmployeeIdentifier_EmployeeId(purchase.getEmployeeIdentifier().getEmployeeId());
                if (employee == null) {
                    throw new NotFoundException("EmployeeId provided is invalid" + purchase.getEmployeeIdentifier().getEmployeeId());
                }
                Membership membership = membershipRepository.findByMembershipIdentifier_MembershipId(purchase.getMembershipIdentifier().getMembershipId());
                if (membership == null) {
                    throw new NotFoundException("MembershipId provided is invalid" + purchase.getMembershipIdentifier().getMembershipId());
                }
                purchaseResponseModelList.add(purchaseResponseMapper.entityToResponseModel(purchase, member, employee, membership));
            });
        return purchaseResponseModelList;


    }

}
