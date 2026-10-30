package mptc.gov.kh.ecommerce.user.exception;

import mptc.gov.kh.ecommerce.restapi.exception.GlobalException;
import org.springframework.http.HttpStatus;

public class UsernameConflictException extends GlobalException {

    public UsernameConflictException(HttpStatus status, String message) {
        super(status, message);
    }
}
