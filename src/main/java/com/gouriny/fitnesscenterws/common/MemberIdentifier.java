package com.gouriny.fitnesscenterws.common;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class MemberIdentifier {

    private String memberId;

    public MemberIdentifier() {
        this.memberId = UUID.randomUUID().toString();
    }



    //no need for a getter, as it is already annotated with @Getter
}
