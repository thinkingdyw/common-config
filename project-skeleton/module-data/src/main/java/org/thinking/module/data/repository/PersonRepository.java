package org.thinking.module.data.repository;

import org.springframework.stereotype.Repository;
import org.thinking.module.domain.Person;

@Repository
public interface PersonRepository {

    public Person getPersonById(long personId);

    public int insertPerson(Person person);
}
