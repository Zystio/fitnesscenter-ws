package com.gouriny.fitnesscenterws.employeemanagementsubdomain.datalayer;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class PhoneNumber {

    @Enumerated(EnumType.STRING)
    private PhoneType type;
    private String number;

    public PhoneNumber(@NotNull PhoneType type, @NotNull String number) {
        this.type = type;
        this.number = number;
    }

    public @NotNull PhoneType getType() {
        return type;
    }

    public @NotNull String getNumber() {
        return number;
    }

}
