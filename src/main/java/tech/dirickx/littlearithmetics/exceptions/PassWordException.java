package tech.dirickx.littlearithmetics.exceptions;

public class PassWordException extends LoginException {
    @Override
    public String getMessage() {
        return "Wrong password";
    }
}
