package mptc.gov.kh.ecommerce.order.domain.exception;

import mptc.gov.kh.ecommerce.domain.exception.DomainException;

public class OrderDomainException extends DomainException {
    public OrderDomainException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderDomainException(String message) {
        super(message);
    }
}
