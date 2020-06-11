package be.intecbrussel.quiz.dao.impl;

import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class JpaSessionUtil {

    private static Map<String, EntityManagerFactory> persistenceUnit = new HashMap<>();

    public static synchronized EntityManager getEntityManager(String persistenceUnitName) {
        persistenceUnit.putIfAbsent(persistenceUnitName, Persistence.createEntityManagerFactory(persistenceUnitName));
        return persistenceUnit.get(persistenceUnitName)
                .createEntityManager();
    }

    public static Session getSession(String persistenceUnitName) {
        return getEntityManager(persistenceUnitName).unwrap(Session.class);
    }

}
