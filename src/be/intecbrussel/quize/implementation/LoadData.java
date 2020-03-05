package be.intecbrussel.quize.implementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoadData {

    String userName;
    Path sourceFolder;

    public LoadData(String userName, Path scourceFolder){
        this.userName = userName;
        this.sourceFolder = scourceFolder;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Path getSourceFolder() {
        return sourceFolder;
    }

    public void setSourceFolder(Path sourceFolder) {
        this.sourceFolder = sourceFolder;
    }

    public void setDestination(String sourceFolder) {
        this.sourceFolder = Paths.get(sourceFolder);
    }

    public QuizService<?> loadQuize(){
        FileInputStream fileIn = null;
        ObjectInputStream objIn = null;
        QuizService<?> quiz = null;
        try{
            fileIn = new FileInputStream(sourceFolder+"\\"+userName);
            objIn = new ObjectInputStream(fileIn);
            quiz = (QuizService<?>) objIn.readObject();
        }catch (IOException | ClassNotFoundException ioe){
            System.out.println("Something went wrong with loading the quiz");
            ioe.printStackTrace();
        }
        return quiz;
    }

}
