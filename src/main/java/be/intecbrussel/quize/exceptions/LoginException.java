package be.intecbrussel.quize.exceptions;

public class LoginException extends Exception {
    @Override
    public String getMessage() {
        return "Login Exception";
    }
}
