package be.intecbrussel.littlearithmetics.dao.impl;

import be.intecbrussel.littlearithmetics.dao.Dao;
import be.intecbrussel.littlearithmetics.dao.QuestionDao;
import be.intecbrussel.littlearithmetics.model.Answer;
import be.intecbrussel.littlearithmetics.model.Question;

import javax.persistence.EntityManager;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {


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
        em.persist(question.getAnswer());
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Question question) {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        Question attachedQuestion = em.merge(question);
        Answer attachedAnswer = em.merge(attachedQuestion.getAnswer());
        em.remove(attachedQuestion);
        em.remove(attachedAnswer);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Question question) {
        EntityManager em = JpaSessionUtil.getEntityManager("dataQuiz");
        em.getTransaction().begin();
        Question foundQuestion = em.merge(em.find(Question.class,question.getId()));
        em.merge(em.find(Answer.class, foundQuestion.getAnswer().getId()));
        em.getTransaction().commit();
        em.close();
    }
}
