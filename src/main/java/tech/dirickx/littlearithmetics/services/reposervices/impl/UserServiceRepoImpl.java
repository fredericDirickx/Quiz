package tech.dirickx.littlearithmetics.services.reposervices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.dirickx.littlearithmetics.models.User;
import tech.dirickx.littlearithmetics.repositories.UserRepository;
import tech.dirickx.littlearithmetics.services.reposervices.UserService;

@Service
public class UserServiceRepoImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceRepoImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByName(String name) {
        User user = userRepository.findByUserName(name).get();
        return user;
    }

    public void encryptUserPassWord(User user) {
        String passWord = user.getPassword();
        user.setPassword(passwordEncoder.encode(passWord));
    }


    @Override
    public void save(User user) {
        encryptUserPassWord(user);
        userRepository.save(user);
    }
}
