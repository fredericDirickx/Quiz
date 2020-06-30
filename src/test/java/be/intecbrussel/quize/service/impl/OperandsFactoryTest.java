package be.intecbrussel.quize.service.impl;

import be.intecbrussel.littlearithmetics.model.OperandBoundaries;
import be.intecbrussel.littlearithmetics.model.QuizSettings;
import be.intecbrussel.littlearithmetics.service.impl.OperandsFactory;
import org.junit.jupiter.api.Test;

class OperandsFactoryTest {

    @Test
    void operandsForQuestion() {
        QuizSettings settings = new QuizSettings();
        OperandBoundaries boundaries = new OperandBoundaries();
        OperandsFactory factory = new OperandsFactory(settings,boundaries);
    }
}