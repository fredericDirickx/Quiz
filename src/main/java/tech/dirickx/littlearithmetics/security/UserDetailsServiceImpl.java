package tech.dirickx.littlearithmetics.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.dirickx.littlearithmetics.models.User;
import tech.dirickx.littlearithmetics.services.modelservice.UserService;

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
