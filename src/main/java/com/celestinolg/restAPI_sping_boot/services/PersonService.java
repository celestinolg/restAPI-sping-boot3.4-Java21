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
    private final List<Person> personMock = new ArrayList<Person>();

    public void setPersonMock() {
        personMock.add(new Person("Celestino", "Langa", "Male", "Luanda, Angola"));
        personMock.add(new Person("Langa", "Celestino", "Male", "Luanda, Angola"));
        personMock.add(new Person("António", "Langa", "Male", "Luanda, Angola"));
        personMock.add(new Person("Augusto", "Langa", "Male", "Luanda, Angola"));
    }

    public List<Person> getPersonMock() {
        this.setPersonMock();
        return personMock;
    }



    public Person findById(String id){
        this.logger.info("Finding person by id: " + id);
        return getPersonMock().get(Integer.parseInt(id));
    }

    public List<Person> findAll(){
        this.logger.info("Finding all persons");
        return this.getPersonMock();
    }

    public Person create(Person person) {

        this.logger.info("Creating person: " + person);
        return person;
    }
}
