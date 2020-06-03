package be.intecbrussel.quize.dao;

import be.intecbrussel.quize.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {
    User user = new User();
    String name = "Test";
    String passWord = "123";
    UserDaoImpl userDao = new UserDaoImpl();

    public UserDaoImplTest(){
        user.setName(name);
        user.setPassword(passWord);
    }


    @Test
    void create() {
        User foundUser = userDao.findByName(name);
        if(foundUser==null) {
            userDao.create(user);
            foundUser = userDao.findByName(name);
        }
        Assertions.assertEquals(foundUser.getName(),user.getName());
    }

    @Test
    void getList() {
        List<User> userList = userDao.getList();
       Assertions.assertTrue(!userList.isEmpty());
    }


    @Test
    void findByName() {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.findByName("NotExisting");
        assertNull(user);
    }

    @Test
    void update() {
        user.setName("Updated");
        userDao.update(user);
        User foundUser = userDao.findByName("Updated");
        Assertions.assertEquals(user.getName(),foundUser.getName());
    }


    @Test
    void delete() {
        User user = this.user;
        userDao.delete(user);
        user.setName("Updated");
        userDao.delete(user);
        User foundUser = userDao.findByName("Updated");
        assertNull(foundUser);
    }



}