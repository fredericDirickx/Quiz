package tech.dirickx.littlearithmetics.services.modelservice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePassWordDummy {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassWord = passwordEncoder.encode("pass");
}
