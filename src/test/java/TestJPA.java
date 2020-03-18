import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;

public class TestJPA {


    Logger log = Logger.getLogger(this.getClass().getName());

    @Test
    public void bootstrapping() {
        System.out.println("....bootstrapping...");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("quiz-persistence-init");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

}
