package tech.dirickx.littlearithmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.dirickx.littlearithmetics.models.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
