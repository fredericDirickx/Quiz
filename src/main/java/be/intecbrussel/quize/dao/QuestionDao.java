package be.intecbrussel.quize.dao;

import be.intecbrussel.quize.model.Question;

import javax.persistence.EntityManager;
import java.util.List;

public class QuestionDao implements QuizDao<Question> {


    @Override
    public List<Question> getList() {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        List<Question> questionList =  em.createQuery("SELECT q  FROM  Question AS q ").getResultList();
        em.close();

        return questionList;
    }

    @Override
    public void create(Question question) {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        em.persist(question);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Question question) {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        Question attachedQuestion = em.merge(question);
        em.remove(attachedQuestion);
        em.close();
    }

    @Override
    public void update(Question question) {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
<<<<<<< HEAD

=======
        em.merge(question);
        em.getTransaction().commit();
        em.close();
>>>>>>> C--Program-Files-tomcat-webapps-quiz
    }
}
