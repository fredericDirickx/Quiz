package be.intecbrussel.quize.dao;

import be.intecbrussel.quize.model.Question;
import be.intecbrussel.quize.model.QuizService;
import be.intecbrussel.quize.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class QuizServiceDao implements QuizDao<QuizService> {

    @Override
    public List getList() {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        List<QuizService> quizServiceList = em.createQuery("SELECT quiz FROM QuizService AS quiz").getResultList();
        return quizServiceList;
    }

    @Override
    public void create(QuizService quizService) {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        User user = quizService.getUser();
        List<Question> questionList = quizService.getQuestions();

        User registeredUser = em.find(User.class, user.getName());
        if (registeredUser == null) {
            em.persist(user);
        } else {
            quizService.setUser(registeredUser);
        }

        em.getTransaction().begin();
        em.persist(quizService);
        em.persist(quizService.getUser());
        for (Question q : quizService.getQuestions() ) {
            em.persist(q);
        }

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(QuizService quizService) {

    }

    @Override
    public void update(QuizService quizService) {

    }
}
