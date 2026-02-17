package com.github.BrunoFontenele;

import com.github.BrunoFontenele.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Finding all People!");

        List<Person> persons = new ArrayList<Person>();

        //mock
        for(int i = 0; i < 8; i++){
            Person person = mockPerson();
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        logger.info("Finding person with id: " + id);

        return mockPerson();
    }

    public Person create(Person person){
        //mock
        logger.info("Creating one person!");

        return person;
    }

    public Person update(Person person){
        //mock
        logger.info("Updating one person!");

        return person;
    }

    public void delete(String id){
        //mock
        logger.info("Deleting one person!");
    }

    private Person mockPerson(){
        //mock
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Firstname " + counter.get());
        person.setLastName("Lastname " + counter.get());
        person.setAddress("Some Address");
        person.setGender("Gender");

        return person;
    }
}
