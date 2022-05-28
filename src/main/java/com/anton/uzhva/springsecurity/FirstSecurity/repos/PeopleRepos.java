package com.anton.uzhva.springsecurity.FirstSecurity.repos;

import com.anton.uzhva.springsecurity.FirstSecurity.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepos  extends JpaRepository<Person, Integer> {

    public Optional<Person> findByUserName (String username);


}
