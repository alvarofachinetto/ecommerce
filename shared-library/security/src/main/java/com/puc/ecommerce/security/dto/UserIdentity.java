package com.puc.ecommerce.security.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserIdentity {

    private UUID Id;
    private String email;
    private String firstName;
    private String lastName;
}
