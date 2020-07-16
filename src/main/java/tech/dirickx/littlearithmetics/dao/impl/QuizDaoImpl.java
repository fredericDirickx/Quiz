package tech.dirickx.littlearithmetics.dao.impl;

import org.springframework.stereotype.Repository;
import tech.dirickx.littlearithmetics.dao.QuizDao;
import tech.dirickx.littlearithmetics.models.Question;
import tech.dirickx.littlearithmetics.models.Quiz;
import tech.dirickx.littlearithmetics.models.User;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class QuizDaoImpl implements QuizDao {

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
        System.out.println(user.getUserName());
        List<Question> questionList = quiz.getQuestions();
        em.getTransaction().begin();

        User registeredUser = em.find(User.class, user.getUserName());
        quiz.setUser(registeredUser);

        em.persist(quiz);

        for (Question q : quiz.getQuestions()) {
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
        em.remove(em.find(Quiz.class, quiz.getId()));
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
