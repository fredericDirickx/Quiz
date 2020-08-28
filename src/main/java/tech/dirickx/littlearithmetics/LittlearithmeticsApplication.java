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
import tech.dirickx.littlearithmetics.services.UserService;
import tech.dirickx.littlearithmetics.services.impl.UserServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = tech.dirickx.littlearithmetics.repositories.UserRepository.class)
public class LittlearithmeticsApplication {
    public static void main(String[] args){
        ApplicationContext applicationContext = SpringApplication.run(LittlearithmeticsApplication.class, args);
    }
}
