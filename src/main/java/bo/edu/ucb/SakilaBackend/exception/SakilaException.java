package bo.edu.ucb.SakilaBackend.exception;

public class SakilaException extends RuntimeException {
    private final Integer code;

    public SakilaException(Integer code, String message) {
        super(message);
        this.code = code;

    }

    public SakilaException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
