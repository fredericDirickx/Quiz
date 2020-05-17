package be.intecbrussel.quize.exceptions;

public class UserNameException extends LoginException {

    @Override
    public String getMessage() {
        return "The user name already Exists";
    }
}
