package tech.dirickx.littlearithmetics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = tech.dirickx.littlearithmetics.repositories.UserRepository.class)
public class LittlearithmeticsApplication extends SpringBootServletInitializer {
    public static void main(String[] args){
        ApplicationContext applicationContext = SpringApplication.run(LittlearithmeticsApplication.class, args);
    }
}
