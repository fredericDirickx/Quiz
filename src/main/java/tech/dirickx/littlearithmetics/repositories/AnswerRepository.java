package tech.dirickx.littlearithmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.dirickx.littlearithmetics.models.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
