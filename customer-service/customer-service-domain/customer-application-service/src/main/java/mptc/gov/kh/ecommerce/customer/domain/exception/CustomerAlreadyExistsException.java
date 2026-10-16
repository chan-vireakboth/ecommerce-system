package mptc.gov.kh.ecommerce.customer.domain.exception;

import mptc.gov.kh.ecommerce.exception.CustomerDomainException;

public class CustomerAlreadyExistsException extends CustomerDomainException {

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
