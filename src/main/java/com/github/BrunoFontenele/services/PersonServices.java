package com.github.BrunoFontenele.services;

import com.github.BrunoFontenele.exception.ResourceNotFoundException;
import com.github.BrunoFontenele.model.Person;
import com.github.BrunoFontenele.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        logger.info("Finding all People!");
        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding person with id: " + id);

        return repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID"));
    }

    public Person create(Person person){
        logger.info("Creating one person!");

        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one person!");

        findById(person.getId());

        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting one person!");

        repository.deleteById(id);
    }


}
