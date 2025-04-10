package com.celestinolg.restAPI_sping_boot.services;

import com.celestinolg.restAPI_sping_boot.model.Person;
import com.celestinolg.restAPI_sping_boot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService  {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PersonRepository repository;
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private final List<Person> personMock = new ArrayList<>();

    public Person findById(Long id){
        this.logger.info("Finding person by id: " + id);
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No person found with id: " + id));
    }

    public List<Person> findAll(){
        this.logger.info("Finding all persons");
        return repository.findAll();
    }

    public Person create(Person person) {
        this.logger.info("Creating person: " + person);
        return repository.save(person);
    }

    public Person update(Person person) {
        this.logger.info("Updating person: " + person.getFirstName() + " " + person.getLastName());
        findById(person.getId());
        return repository.save(person);
    }

    public void delete(Long id) {
        this.logger.info("Deleting person: " + id);
        Person person = findById(id);
        repository.delete(person);
    }
}
