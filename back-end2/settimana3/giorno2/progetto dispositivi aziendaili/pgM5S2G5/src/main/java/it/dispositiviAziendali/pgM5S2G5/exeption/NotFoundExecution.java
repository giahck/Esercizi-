package it.dispositiviAziendali.pgM5S2G5.exeption;

public class NotFoundExecution extends RuntimeException {
    public NotFoundExecution(String message) {
        super(message);
    }
}
