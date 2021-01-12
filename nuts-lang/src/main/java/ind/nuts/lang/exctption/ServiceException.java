package ind.nuts.lang.exctption;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author haoyun.zheng
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -8088838882285969561L;

    private String errorCode;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ServiceException(String errorCode, String message, Throwable throwable) {
        super(message, throwable);
        this.errorCode = errorCode;
    }

}
