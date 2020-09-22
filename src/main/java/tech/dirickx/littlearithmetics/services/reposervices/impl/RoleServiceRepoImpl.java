package tech.dirickx.littlearithmetics.services.reposervices.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.dirickx.littlearithmetics.models.Role;
import tech.dirickx.littlearithmetics.repositories.RoleRepository;
import tech.dirickx.littlearithmetics.services.reposervices.RoleService;

@Service
public class RoleServiceRepoImpl implements RoleService {

    RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findByName(name).orElse(null);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
}
