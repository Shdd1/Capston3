package spring.boot.capston2.API;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
