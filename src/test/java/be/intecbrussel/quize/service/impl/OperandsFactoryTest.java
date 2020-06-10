package be.intecbrussel.quize.service.impl;

import be.intecbrussel.quize.model.OperandBoundaries;
import be.intecbrussel.quize.model.QuizSettings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperandsFactoryTest {

    @Test
    void operandsForQuestion() {
        QuizSettings settings = new QuizSettings();
        OperandBoundaries boundaries = new OperandBoundaries();
        OperandsFactory factory = new OperandsFactory(settings,boundaries);
    }
}