package mptc.gov.kh.ecommerce.customer.domain.exception;

import mptc.gov.kh.ecommerce.exception.CustomerDomainException;

public class CustomerNotFoundException extends CustomerDomainException {

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
