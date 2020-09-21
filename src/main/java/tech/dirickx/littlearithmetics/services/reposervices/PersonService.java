package tech.dirickx.littlearithmetics.services.reposervices;

import tech.dirickx.littlearithmetics.models.Person;
import tech.dirickx.littlearithmetics.models.User;

public interface PersonService {
    Person findUserById(Long id);
    void save(Person person);
}
