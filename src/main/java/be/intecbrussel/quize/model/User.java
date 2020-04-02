package be.intecbrussel.quize.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    private String name;

    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
