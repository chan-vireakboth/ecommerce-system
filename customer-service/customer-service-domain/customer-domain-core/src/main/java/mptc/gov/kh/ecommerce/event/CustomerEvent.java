package mptc.gov.kh.ecommerce.event;

import mptc.gov.kh.ecommerce.domain.event.DomainEvent;
import mptc.gov.kh.ecommerce.entity.Customer;

public abstract class CustomerEvent implements DomainEvent<Customer> {
    private final Customer customer;

    public CustomerEvent(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

}
