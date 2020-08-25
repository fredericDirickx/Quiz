package tech.dirickx.littlearithmetics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tech.dirickx.littlearithmetics.models.Address;
import tech.dirickx.littlearithmetics.models.Person;
import tech.dirickx.littlearithmetics.models.Role;
import tech.dirickx.littlearithmetics.models.User;
import tech.dirickx.littlearithmetics.repositories.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = tech.dirickx.littlearithmetics.repositories.UserRepository.class)
public class LittlearithmeticsApplication {
    public static void main(String[] args){
        ApplicationContext applicationContext = SpringApplication.run(LittlearithmeticsApplication.class, args);

        UserRepository userRepository = applicationContext.getBean(UserRepository.class);

//        Person person = new Person();
//        Address address = new Address();
//        Role role = new Role();
//        User user = new User();
//
//
//        person.setEmail("frederic.dirickx@gmail.com");
//        person.setFirstName("Frederic");
//        person.setFamilyName("Dirickx");
//        person.setDateOfBirth(LocalDate.of(1980,3,4));
//        person.setPhoneNumber("0479826952");
//        person.setAddress(address);
//        person.setUser(user);
//
//        address.setStreet("Wandelingstraat");
//        address.setStreetNumber("40");
//        address.setPostalCode("1070");
//        address.setCity("Anderlecht");
//        address.setCountry("Belgium");
//        address.setPerson(person);
//
//        role.setName("USER");
//        Collection<User> users = new ArrayList<>();
//        users.add(user);
//        role.setUsers(users);
//
//        user.setPerson(person);
//        user.setUserName("frits");
//        user.setPassword("password");
//        user.addRole(role);
//        user.setEnabled(true);
//
//        user.addRole(role);
//
//        userRepository.delete(user);
    }
}
