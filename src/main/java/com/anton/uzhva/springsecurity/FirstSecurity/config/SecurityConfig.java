package com.anton.uzhva.springsecurity.FirstSecurity.config;

import com.anton.uzhva.springsecurity.FirstSecurity.services.PersonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public SecurityConfig(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }


    //  метод настраивает аутентификацию
    public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(personDetailsService);

    }

    @Bean
    public PasswordEncoder getPasswordEncoder () {
        return NoOpPasswordEncoder.getInstance();

    }
}
