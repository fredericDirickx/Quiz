package tech.dirickx.littlearithmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.dirickx.littlearithmetics.models.Role;
import tech.dirickx.littlearithmetics.models.User;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT role FROM Role role WHERE role.name = ?1")
    Optional<Role> findByName(String userName);
}
