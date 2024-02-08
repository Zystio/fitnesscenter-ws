package com.gouriny.fitnesscenterws.clientmanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class ClientIdentifier {

    private String clientId;

    public ClientIdentifier() {
        this.clientId = UUID.randomUUID().toString();
    }

    //no need for a getter, as it is already annotated with @Getter
}
