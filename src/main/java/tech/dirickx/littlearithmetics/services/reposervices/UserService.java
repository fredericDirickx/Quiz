package tech.dirickx.littlearithmetics.services.reposervices;

import tech.dirickx.littlearithmetics.models.User;

public interface UserService {
    User findUserByName(String name);
    void save(User user);
}
