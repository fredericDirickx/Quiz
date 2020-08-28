package tech.dirickx.littlearithmetics.services.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thymeleaf.engine.ElementName;

public class EncodePassWordDummy {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassWord = passwordEncoder.encode("pass");
}
