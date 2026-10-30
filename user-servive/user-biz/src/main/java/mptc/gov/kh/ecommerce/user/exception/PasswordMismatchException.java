package mptc.gov.kh.ecommerce.user.exception;

import org.springframework.http.HttpStatus;

public class PasswordMismatchException extends RuntimeException{
    public PasswordMismatchException(HttpStatus status, String message) {
        super(message);
    }
}
