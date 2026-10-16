package mptc.gov.kh.ecommerce.event;

import mptc.gov.kh.ecommerce.domain.event.DomainEvent;
import mptc.gov.kh.ecommerce.domain.valueobject.CustomerId;
import mptc.gov.kh.ecommerce.entity.Customer;

import java.time.ZonedDateTime;

public class CustomerDeactivatedEvent implements DomainEvent<Customer> {
    private final CustomerId customerId;
    private final ZonedDateTime deactivatedAt;

    public CustomerDeactivatedEvent(CustomerId customerId, ZonedDateTime deactivatedAt){
        this.customerId = customerId;
        this.deactivatedAt = deactivatedAt;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public ZonedDateTime getDeactivatedAt() {
        return deactivatedAt;
    }
}
