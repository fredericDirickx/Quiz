package tech.dirickx.littlearithmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.dirickx.littlearithmetics.models.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
