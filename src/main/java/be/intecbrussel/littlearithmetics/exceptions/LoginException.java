package be.intecbrussel.littlearithmetics.exceptions;

public class LoginException extends Exception {
    @Override
    public String getMessage() {
        return "Login Exception";
    }
}
