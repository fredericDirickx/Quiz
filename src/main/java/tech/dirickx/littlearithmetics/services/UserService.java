package tech.dirickx.littlearithmetics.services;

import tech.dirickx.littlearithmetics.models.User;

public interface UserService {
    User findUserByName(String name);
    void save(User user);
}
