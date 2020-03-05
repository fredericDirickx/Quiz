package be.intecbrussel.quize.implementation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SafeData {

    QuizService<?> QuizService;
    String userName;
    Path destination;

    public SafeData(QuizService<?> quizService, String userName, Path destination){
        this.QuizService = quizService;
        this.userName = userName;
        this.destination = destination;
    }

    public be.intecbrussel.quize.implementation.QuizService<?> getQuizService() {
        return QuizService;
    }

    public void setQuizService(be.intecbrussel.quize.implementation.QuizService<?> quizService) {
        QuizService = quizService;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Path getDestination() {
        return destination;
    }

    public void setDestination(Path destination) {
        this.destination = destination;
    }

    public void setDestination(String destination) {
        this.destination = Paths.get(destination);
    }



    public void safeToDrive(String userName, Path destination) {
        FileOutputStream fileOut = null;
        ObjectOutputStream objSafe = null;
        try {
            fileOut = new FileOutputStream(destination + "\\" + userName);
            objSafe = new ObjectOutputStream(fileOut);
            objSafe.writeObject(QuizService);
            objSafe.close();
            fileOut.close();
        } catch (IOException ioe) {
            System.err.println("Something went wrong with saving the game to drive");
            ioe.printStackTrace();
        }
    }

    public void safeToDrive() {
        FileOutputStream fileOut = null;
        ObjectOutputStream objSafe = null;
        try {
            fileOut = new FileOutputStream(this.destination + "\\" + this.userName);
            objSafe = new ObjectOutputStream(fileOut);
            objSafe.writeObject(this.QuizService);
            objSafe.close();
            fileOut.close();
        } catch (IOException ioe) {
            System.err.println("Something went wrong with saving the game to drive");
            ioe.printStackTrace();
        }
    }
}
