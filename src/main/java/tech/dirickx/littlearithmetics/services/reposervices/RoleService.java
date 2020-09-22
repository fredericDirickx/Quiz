package tech.dirickx.littlearithmetics.services.reposervices;

import tech.dirickx.littlearithmetics.models.Role;

public interface RoleService {
    public Role findRoleByName(String name);

    public void save(Role role);
}
