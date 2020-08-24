package tech.dirickx.littlearithmetics.services.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import tech.dirickx.littlearithmetics.models.Address;
import tech.dirickx.littlearithmetics.models.Person;
import tech.dirickx.littlearithmetics.models.Role;
import tech.dirickx.littlearithmetics.models.User;
import tech.dirickx.littlearithmetics.repositories.AddressRepository;
import tech.dirickx.littlearithmetics.repositories.UserRepository;
import tech.dirickx.littlearithmetics.services.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;


class UserServiceImplTest {

    @Test
    void findUserByName() {
    }


    @Test
    @Bean
    public void addUser(UserServiceImpl userRepository){
        Person person = new Person();
        Address address = new Address();
        Role role = new Role();
        User user = new User();


        person.setEmail("frederic.dirickx@gmail.com");
        person.setFirstName("Frederic");
        person.setFamilyName("Dirickx");
        person.setDateOfBith(LocalDate.of(1980,3,4));
        person.setPhoneNumber("0479826952");
        person.setAddress(address);

        address.setStreet("Wandelingstraat");
        address.setStreetNumber("40");
        address.setPostalCode("1070");
        address.setCity("Anderlecht");
        address.setCountry("Belgium");

        role.setName("USER");
        Collection<User> users = new ArrayList<>();
        users.add(user);
        role.setUsers(users);

        user.setPerson(person);
        user.setUserName("frits");
        user.setPassword("password");
        user.addRole(role);
        user.setEnabled(true);

        user.addRole(role);
        userRepository.save(user);
    }
}