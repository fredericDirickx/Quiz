package tech.dirickx.littlearithmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import tech.dirickx.littlearithmetics.models.Person;

import javax.transaction.Transactional;

@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {
}
