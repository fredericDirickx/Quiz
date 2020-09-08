package tech.dirickx.littlearithmetics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.dirickx.littlearithmetics.models.QuizSettings;

public interface QuizSettingsRepository extends JpaRepository<QuizSettings, Integer> {
}
