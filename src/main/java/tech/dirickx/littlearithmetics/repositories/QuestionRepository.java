package tech.dirickx.littlearithmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.dirickx.littlearithmetics.models.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
