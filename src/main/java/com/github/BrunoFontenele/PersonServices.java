package com.github.BrunoFontenele;

import com.github.BrunoFontenele.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding person with id: " + id);

        //mock
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Teste");
        person.setLastName("Testando");
        person.setAddress("Moscow - USSR");
        person.setGender("Male");

        return person;
    }
}
