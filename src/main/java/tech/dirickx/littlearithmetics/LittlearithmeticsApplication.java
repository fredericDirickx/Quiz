package tech.dirickx.littlearithmetics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tech.dirickx.littlearithmetics.dao.UserDao;
import tech.dirickx.littlearithmetics.dao.impl.UserDaoImpl;
import tech.dirickx.littlearithmetics.models.Address;
import tech.dirickx.littlearithmetics.models.Person;
import tech.dirickx.littlearithmetics.models.Role;
import tech.dirickx.littlearithmetics.models.User;

import javax.persistence.PersistenceUnit;
import java.time.LocalDate;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = tech.dirickx.littlearithmetics.repositories.UserRepository.class)
public class LittlearithmeticsApplication {
    public static void main(String[] args){
        ApplicationContext applicationContext = SpringApplication.run(LittlearithmeticsApplication.class, args);
        Address address = new Address();
        address.setCity("Anderlecht");
        address.setCountry("Belgium");
        address.setPostalCode("1070");
        address.setStreet("Wandelingstraat");
        address.setStreetNumber("40");

        Person person = new Person();
        person.setFamilyName("Dirickx");
        person.setFirstName("Frederic");
        person.setEmail("frederic.dirickx@gmail.com");
        person.setPhoneNumber("0479826952");
        person.setDateOfBith(LocalDate.of(1980, 3,4));
        person.setAddress(address);

        Role role = new Role();
        role.setName("USER");

        User user = new User();
        user.addRole(role);
        user.setUserName("Frits");
        user.setPassword("123");
        user.setPerson(person);

        UserDao userDao = new UserDaoImpl();

        userDao.create(user);



    }
}
