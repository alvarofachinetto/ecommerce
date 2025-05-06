package com.puc.ecommerce.security;

import com.puc.ecommerce.security.dto.UserIdentity;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.UUID;

public class UserIdentityExtensions {

    public static UserIdentity getUserIdentity(Jwt jwt) {
        var userId = UUID.fromString(jwt.getSubject());

        var userIdentity = new UserIdentity();
        userIdentity.setId(userId);

        return  userIdentity;
    }
}
