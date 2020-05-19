package be.intecbrussel.quize.model;

import be.intecbrussel.quize.dao.QuizServiceDao;
import be.intecbrussel.quize.dao.UserDao;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

class QuizServiceTest {

//    @Test
    public void testDb(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("datasource");
        NumberGenerator numberGenerator = new NumberGenerator(1,10,1,10);
        QuizService quiz = new QuizService();
        quiz.setAmountQuestions(10);
        quiz.setIsMultiplication(true);
        quiz.setNumberGenerator(numberGenerator);
        User user = new User();
        user.setName("Frits");
        quiz.setUser(user);
        quiz.createQuiz();

        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(quiz);
        em.persist(user);

        for (Question q : quiz.getQuestions()) {
            em.persist(q);
        }

        em.getTransaction().commit();

        em.close();
        factory.close();
    }

//    @Test
    void gradeQuizToList() {
        QuizService quizService = new QuizService();
        User user = new User();
        user.setName("Frits");
        user.setPassword("123");
        quizService.setUser(user);
        quizService.createQuiz();
        String[] questions =  quizService.getQuestions().stream().map(Question::getQuestionString).toArray(String[]::new);
        String[] answers = new String[questions.length];
        for (int i = 0 ; i < questions.length ; i++) {
            answers[i] = String.valueOf(i);
        }

        QuizService quizService1 = QuizService.createQuiz(answers,questions,user.getName());

//        QuizServiceDao quizServiceDao = new QuizServiceDao();

//        quizServiceDao.create(quizService1);


        quizService1.gradeQuizToList().forEach(System.out::println);




    }
}