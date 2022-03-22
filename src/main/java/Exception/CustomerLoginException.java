package Exception;

public class CustomerLoginException extends RuntimeException {

    private Integer status;

    private String error;

    private String message;

    public CustomerLoginException(Integer status, String error, String message) {
        super();
        this.status = status;
        this.error = error;
        this.message = message;
    }

}
