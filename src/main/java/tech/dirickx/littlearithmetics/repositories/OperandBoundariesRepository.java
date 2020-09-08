package tech.dirickx.littlearithmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.dirickx.littlearithmetics.models.OperandBoundaries;

public interface OperandBoundariesRepository extends JpaRepository<OperandBoundaries, Integer> {
}
