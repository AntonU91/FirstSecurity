package com.anton.uzhva.springsecurity.FirstSecurity.security;

import com.anton.uzhva.springsecurity.FirstSecurity.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public AuthProviderImpl(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override  // в этом методе будет лежать вся логика аутентификации
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        UserDetails personDetails = personDetailsService.loadUserByUsername(name);
        String password = authentication.getCredentials().toString();
        if (!password.equals(personDetails.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }
        return new  UsernamePasswordAuthenticationToken (personDetails, password, Collections.emptyList());
    }

    @Override // этот метод технический и нужен он чтоб понять для какого обьекта Authentication
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
