package com.terekh.portfl.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public final class SecurityHelper {

    public static Long getUserId() {
        return loggedUser().getId();
    }

    public static PortflUserDetails loggedUser() {
        return (PortflUserDetails) getAuthenticationWithCheck().getPrincipal();
    }

    public static Authentication getAuthenticationWithCheck() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean checkAuthenticationExists = authentication != null && authentication.isAuthenticated();
        if (checkAuthenticationExists) {
            return authentication;
        }

        throw new BadCredentialsException("Authentication failed.");
    }
}
