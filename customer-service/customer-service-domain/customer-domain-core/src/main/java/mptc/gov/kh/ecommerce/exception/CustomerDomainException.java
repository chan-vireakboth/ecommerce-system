package mptc.gov.kh.ecommerce.exception;

import mptc.gov.kh.ecommerce.domain.exception.DomainException;

public class CustomerDomainException  extends DomainException {
    public CustomerDomainException(String message) {
        super(message);
    }

    public CustomerDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
