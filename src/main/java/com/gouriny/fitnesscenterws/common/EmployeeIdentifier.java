package com.gouriny.fitnesscenterws.common;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.UUID;

@Embeddable
@Getter
public class EmployeeIdentifier {

    private String employeeId;

    public EmployeeIdentifier() {
        this.employeeId = UUID.randomUUID().toString();
    }

}
