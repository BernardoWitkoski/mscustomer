package Exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerException extends RuntimeException {

    private Integer status;

    private String error;

    private String message;

    public CustomerException(Integer status, String error, String message) {
        super();
        this.status = status;
        this.error = error;
        this.message = message;
    }

}
