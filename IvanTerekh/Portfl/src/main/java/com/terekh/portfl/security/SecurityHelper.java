package com.terekh.portfl.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.terekh.portfl.repository.UserRepository;

public final class SecurityHelper {

    public static Long getUserId() {
    	try{
    		return loggedUser().getId();
    	} catch(ClassCastException exception) {
    		return -1L;
    	}
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
