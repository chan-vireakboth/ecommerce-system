package mptc.gov.kh.ecommerce.user.exception;

import mptc.gov.kh.ecommerce.restapi.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends GlobalException {
    public UserNotFoundException(String message, HttpStatus status) {
        super(status, message);
    }
}
