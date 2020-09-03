package tech.dirickx.littlearithmetics.services.modelservice;

import tech.dirickx.littlearithmetics.models.User;

public interface UserService {
    User findUserByName(String name);
    void save(User user);
}
