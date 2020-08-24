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
    }
}
