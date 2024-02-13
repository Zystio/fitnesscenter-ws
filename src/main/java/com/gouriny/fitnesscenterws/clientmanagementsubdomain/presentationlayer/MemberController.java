package com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer;


import com.gouriny.fitnesscenterws.clientmanagementsubdomain.businesslayer.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/members")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping()
    public ResponseEntity<List<MemberResponseModel>> getAllMembers(){
        return ResponseEntity.ok().body(memberService.getAllMembers());
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponseModel> getClientByClientId(@PathVariable UUID memberId){
        return ResponseEntity.ok().body(memberService.getMemberByMemberId(memberId));
    }

    @PostMapping()
    public ResponseEntity<MemberResponseModel> addClient(@RequestBody MemberRequestModel memberRequestModel){
        MemberResponseModel memberResponseModel = memberService.addMember(memberRequestModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberResponseModel);
    }

    @PutMapping("/{memberId}")
    public ResponseEntity <MemberResponseModel> updateClient(@RequestBody MemberRequestModel memberRequestModel, @PathVariable UUID memberId){
        MemberResponseModel memberResponseModel = memberService.updateMember(memberRequestModel, memberId);
        return ResponseEntity.status(HttpStatus.OK).body(memberResponseModel);
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteClient(@PathVariable UUID memberId){
        memberService.deleteClient(memberId);
        return ResponseEntity.noContent().build();
    }



}
