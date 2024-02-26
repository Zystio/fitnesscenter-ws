package com.gouriny.fitnesscenterws.clientmanagementsubdomain.presentationlayer;


import com.gouriny.fitnesscenterws.clientmanagementsubdomain.businesslayer.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/v1/members")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<MemberResponseModel>> getAllMembers(){
        return ResponseEntity.ok().body(memberService.getAllMembers());
    }

    @GetMapping(value = "/{memberId}")
    public ResponseEntity<MemberResponseModel> getMemberByMemberId(@PathVariable UUID memberId){
        return ResponseEntity.ok().body(memberService.getMemberByMemberId(memberId));
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<MemberResponseModel> addClient(@RequestBody MemberRequestModel memberRequestModel){
        MemberResponseModel memberResponseModel = memberService.addMember(memberRequestModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberResponseModel);
    }

    @PutMapping(value = "/{memberId}", produces = "application/json", consumes = "application/json")
    public ResponseEntity <MemberResponseModel> updateClient(@RequestBody MemberRequestModel memberRequestModel, @PathVariable UUID memberId){
        MemberResponseModel memberResponseModel = memberService.updateMember(memberRequestModel, memberId);
        return ResponseEntity.status(HttpStatus.OK).body(memberResponseModel);
    }

    @DeleteMapping(value = "/{memberId}")
    public ResponseEntity<Void> deleteClient(@PathVariable UUID memberId){
        memberService.deleteClient(memberId);
        return ResponseEntity.noContent().build();
    }



}
