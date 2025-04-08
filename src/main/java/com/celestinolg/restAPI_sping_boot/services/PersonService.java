package com.celestinolg.restAPI_sping_boot.services;

import com.celestinolg.restAPI_sping_boot.model.Person;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService  {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private final List<Person> personMock = new ArrayList<>();

    private void initPersonMock() {
        if (personMock.isEmpty()) {
            personMock.add(new Person("Celestino", "Langa", "Male", "Luanda, Angola"));
            personMock.add(new Person("Langa", "Celestino", "Male", "Luanda, Angola"));
            personMock.add(new Person("António", "Langa", "Male", "Luanda, Angola"));
            personMock.add(new Person("Augusto", "Langa", "Male", "Luanda, Angola"));
        }
    }

    private List<Person> getPersonMock() {
        //initPersonMock();
        return personMock;
    }

    public Person findById(String id){
        this.logger.info("Finding person by id: " + id);
        return getPersonMock().stream().filter(person -> person.getId().equals(Long.parseLong(id))).findFirst().orElse(null);
    }

    public List<Person> findAll(){
        this.logger.info("Finding all persons");
        return getPersonMock();
    }

    public Person create(Person person) {
        this.logger.info("Creating person: " + person);
        person.setId(counter.incrementAndGet());
        personMock.add(person);
        return person;
    }

    public Person update(Person person) {
        this.logger.info("Updating person: " + person);
        getPersonMock().stream().filter(person1 -> person1.getId().equals(person.getId())).findFirst().ifPresent(person1 -> {
            person1.setFirstName(person.getFirstName());
            person1.setLastName(person.getLastName());
            person1.setGender(person.getGender());
            person1.setAddress(person.getAddress());
        });
        return person;
    }

    public boolean delete(String id) {
        this.logger.info("Deleting person: " + id);
        Person person = findById(id);
        return getPersonMock().remove(person);
    }
}
