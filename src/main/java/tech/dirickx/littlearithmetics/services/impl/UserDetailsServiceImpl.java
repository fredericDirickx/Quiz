package tech.dirickx.littlearithmetics.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.dirickx.littlearithmetics.models.User;
import tech.dirickx.littlearithmetics.models.UserDetailsImpl;
import tech.dirickx.littlearithmetics.repositories.UserRepository;
import tech.dirickx.littlearithmetics.services.UserService;

import java.util.Optional;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findUserByName(userName);
        if(user==null){
            throw new UsernameNotFoundException("Not Found: " + userName);
        }
        System.out.println(user.getUserName());
        return new UserDetailsImpl(user);
    }




}
