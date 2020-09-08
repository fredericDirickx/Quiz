package tech.dirickx.littlearithmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.dirickx.littlearithmetics.models.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
