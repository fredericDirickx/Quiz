package be.intecbrussel.quiz.dao.impl;

import be.intecbrussel.quiz.dao.QuizDao;
import be.intecbrussel.quiz.model.Question;
import be.intecbrussel.quiz.model.Quiz;
import be.intecbrussel.quiz.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public class QuizDaoImpl implements QuizDao<Quiz> {

    @Override
    public List getList() {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        List<Quiz> quizList = em.createQuery("SELECT q FROM Quiz AS q").getResultList();
        return quizList;
    }


    @Override
    public void create(Quiz quiz) {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        User user = quiz.getUser();
        System.out.println(user.getName());
        List<Question> questionList = quiz.getQuestions();
        em.getTransaction().begin();

        User registeredUser = em.find(User.class, user.getName());
        quiz.setUser(registeredUser);

        em.persist(quiz);

        for (Question q : quiz.getQuestions() ) {
            em.persist(q);
            em.persist(q.getAnswer());
        }

        em.persist(quiz.getSettings());
        em.persist(quiz.getBoundaries());

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Quiz quiz) {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        em.remove(em.find(Quiz.class,quiz.getId()));
        em.getTransaction().commit();
    }

    @Override
    public void update(Quiz quiz) {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        em.merge(em.find(Quiz.class, quiz));
        em.getTransaction().commit();
    }
}
