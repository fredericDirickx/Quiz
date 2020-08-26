package tech.dirickx.littlearithmetics.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.dirickx.littlearithmetics.models.User;
import tech.dirickx.littlearithmetics.repositories.UserRepository;
import tech.dirickx.littlearithmetics.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByUserName(name).get();
    }

    public void encryptUserPassWord(User user) {
        String passWord = user.getPassword();
        user.setEncryptedPassword(passwordEncoder.encode(passWord));
    }

    @Override
    public void save(User user) {
        encryptUserPassWord(user);
        userRepository.save(user);
    }
}
