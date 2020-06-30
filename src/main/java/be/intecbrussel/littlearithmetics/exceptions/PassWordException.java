package be.intecbrussel.littlearithmetics.exceptions;

public class PassWordException extends LoginException {
    @Override
    public String getMessage() {
        return "Wrong password";
    }
}
