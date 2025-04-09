package com.celestinolg.restAPI_sping_boot.repository;

import com.celestinolg.restAPI_sping_boot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
