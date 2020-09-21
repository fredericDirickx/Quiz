package tech.dirickx.littlearithmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.dirickx.littlearithmetics.models.Question;
import tech.dirickx.littlearithmetics.models.Quiz;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
