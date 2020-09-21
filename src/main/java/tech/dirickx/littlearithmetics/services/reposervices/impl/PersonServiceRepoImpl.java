package tech.dirickx.littlearithmetics.services.reposervices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import tech.dirickx.littlearithmetics.models.Person;
import tech.dirickx.littlearithmetics.models.User;
import tech.dirickx.littlearithmetics.repositories.PersonRepository;
import tech.dirickx.littlearithmetics.services.reposervices.PersonService;

@Service
public class PersonServiceRepoImpl implements PersonService {

    PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person findUserById(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }
}
