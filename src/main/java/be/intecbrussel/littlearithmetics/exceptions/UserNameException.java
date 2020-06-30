package be.intecbrussel.littlearithmetics.exceptions;

public class UserNameException extends LoginException {

    @Override
    public String getMessage() {
        return "The user name already Exists";
    }
}
