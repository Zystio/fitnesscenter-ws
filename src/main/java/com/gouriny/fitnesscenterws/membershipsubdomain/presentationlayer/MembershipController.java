package com.gouriny.fitnesscenterws.membershipsubdomain.presentationlayer;

import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberRequestModel;
import com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer.MemberResponseModel;
import com.gouriny.fitnesscenterws.membershipsubdomain.businesslayer.MembershipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/v1/memberships")
public class MembershipController {

    private MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<MembershipResponseModel>> getAllMemberships() {
        return ResponseEntity.ok().body(membershipService.getAllMemberships());
    }

    @GetMapping(value = "/{membershipId}", produces = "application/json")
    public ResponseEntity<MembershipResponseModel> getMembershipByMembershipId(@PathVariable UUID membershipId) {
        return ResponseEntity.ok().body(membershipService.getMembershipByMembershipId(membershipId));
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<MembershipResponseModel> addMembership(@RequestBody MembershipRequestModel membershipRequestModel) {
        MembershipResponseModel membershipResponseModel = membershipService.addMembership(membershipRequestModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(membershipResponseModel);
    }

    @PutMapping(value = "/{membershipId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<MembershipResponseModel> updateMembership(@RequestBody MembershipRequestModel membershipRequestModel, @PathVariable UUID membershipId) {
        MembershipResponseModel membershipResponseModel = membershipService.updateMembership(membershipRequestModel, membershipId);
        return ResponseEntity.status(HttpStatus.OK).body(membershipResponseModel);
    }

    @DeleteMapping("/{membershipId}")
    public ResponseEntity<Void> deleteMembership(@PathVariable UUID membershipId) {
        membershipService.deleteMembership(membershipId);
        return ResponseEntity.noContent().build();
    }




//    @GetMapping()
//    public ResponseEntity<List<MemberResponseModel>> getAllMembers(){
//        return ResponseEntity.ok().body(memberService.getAllMembers());
//    }
//
//    @GetMapping("/{memberId}")
//    public ResponseEntity<MemberResponseModel> getClientByClientId(@PathVariable UUID memberId){
//        return ResponseEntity.ok().body(memberService.getMemberByMemberId(memberId));
//    }
//
//    @PostMapping()
//    public ResponseEntity<MemberResponseModel> addClient(@RequestBody MemberRequestModel memberRequestModel){
//        MemberResponseModel memberResponseModel = memberService.addMember(memberRequestModel);
//        return ResponseEntity.status(HttpStatus.CREATED).body(memberResponseModel);
//    }
//
//    @PutMapping("/{memberId}")
//    public ResponseEntity <MemberResponseModel> updateClient(@RequestBody MemberRequestModel memberRequestModel, @PathVariable UUID memberId){
//        MemberResponseModel memberResponseModel = memberService.updateMember(memberRequestModel, memberId);
//        return ResponseEntity.status(HttpStatus.OK).body(memberResponseModel);
//    }
//
//    @DeleteMapping("/{memberId}")
//    public ResponseEntity<Void> deleteClient(@PathVariable UUID memberId){
//        memberService.deleteClient(memberId);
//        return ResponseEntity.noContent().build();
//    }
}
