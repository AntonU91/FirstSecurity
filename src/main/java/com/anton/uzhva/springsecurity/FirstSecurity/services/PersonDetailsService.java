package com.anton.uzhva.springsecurity.FirstSecurity.services;

import com.anton.uzhva.springsecurity.FirstSecurity.model.Person;
import com.anton.uzhva.springsecurity.FirstSecurity.repos.PeopleRepos;
import com.anton.uzhva.springsecurity.FirstSecurity.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService // что бы Spring Security  знал что этот сервис(PersonDetailsService)
// загружает пользователя нужно implements UserDetailsService
{

        private final PeopleRepos peopleRepos;

        @Autowired
        public PersonDetailsService(PeopleRepos peopleRepos) {
            this.peopleRepos = peopleRepos;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            Optional<Person> user = peopleRepos.findByUserName(username);
            if (user.isPresent()) {
                return new PersonDetails(user.get());
            } else {
                throw new UsernameNotFoundException("User has not been found");
            }
        }
}
