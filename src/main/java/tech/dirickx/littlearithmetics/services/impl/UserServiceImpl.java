package tech.dirickx.littlearithmetics.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dirickx.littlearithmetics.models.Person;
import tech.dirickx.littlearithmetics.models.Role;
import tech.dirickx.littlearithmetics.models.User;
import tech.dirickx.littlearithmetics.repositories.AddressRepository;
import tech.dirickx.littlearithmetics.repositories.PersonRepository;
import tech.dirickx.littlearithmetics.repositories.RoleRepository;
import tech.dirickx.littlearithmetics.repositories.UserRepository;
import tech.dirickx.littlearithmetics.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository){

    }

    @Override
    public User findUserByName(String name) {
       return userRepository.findByUserName(name).get();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
