import be.intecbrussel.quize.implementation.NumberGenerator;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.RoundingMode;
import java.util.logging.Logger;

public class TestJPA {


    Logger log = Logger.getLogger(this.getClass().getName());

//    @Test
    public void bootstrapping() {
        System.out.println("....bootstrapping...");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("quiz-persistence-init");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @Test
    public static void main(String[] args) {

        double number = 8.3553;
        double divisor = 1;
        double result = 1;
        boolean repeat = true;
        while (repeat) {


            divisor *= 10;

            result = (number * divisor) % 1;



            repeat = !(result == 0);



        }

        System.out.println(Math.log10(divisor));

    }

}
