package tech.dirickx.littlearithmetics.exceptions;

public class LoginException extends Exception {
    @Override
    public String getMessage() {
        return "Login Exception";
    }
}
