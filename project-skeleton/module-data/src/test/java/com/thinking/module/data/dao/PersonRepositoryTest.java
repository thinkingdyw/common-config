package com.thinking.module.data.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thinking.module.data.repository.PersonRepository;
import org.thinking.module.domain.Person;
import org.thinking.module.domain.Person.Gender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/META-INF/module-data.xml"})
public class PersonRepositoryTest {

    @Autowired private PersonRepository personRepository;
    
    @Test
    public void getPerson(){
        Person person = personRepository.getPersonById(1);
        Assert.assertNotNull(person);
        System.out.println(person.getGender());
    }
    
    @Test
    public void insertPerson(){
        Person person = new Person();
        person.setGender(Gender.MALE);
        person.setName("thinking");
        
        int count = personRepository.insertPerson(person);
        
        Assert.assertEquals(true, count==1);
    }
}