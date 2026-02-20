package com.github.BrunoFontenele.repository;

import com.github.BrunoFontenele.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}
