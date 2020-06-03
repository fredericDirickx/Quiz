
package be.intecbrussel.quize.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextInitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}