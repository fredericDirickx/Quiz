package tech.dirickx.littlearithmetics.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("login/login");
//        registry.addViewController("/newUser").setViewName("login/newUser");
//        registry.addViewController("/saveUser").setViewName("login/login");
//        registry.addViewController("/logout").setViewName("login/logout");
    }
}
