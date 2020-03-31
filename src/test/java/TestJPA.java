import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Random;
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

        Random random = new Random();

        double lower = 3;
        double upper = 11;
        double result = 0;
        String good = "";

        for(int i = 0 ; i < 10 ; i++){
           result =    random.nextInt(    (int)upper - (int) lower    )   + (int)lower;

           if(result < upper || result > lower){
               good = "Top";
           }
           else {
               good = "bad";
           }
            System.out.println(result + " " + good);
        }



    }

}
