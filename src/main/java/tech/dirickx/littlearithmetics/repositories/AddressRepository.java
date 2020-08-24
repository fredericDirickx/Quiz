package tech.dirickx.littlearithmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.dirickx.littlearithmetics.models.Address;

import javax.transaction.Transactional;

@Transactional
public interface AddressRepository extends JpaRepository<Address, Long> {

}
