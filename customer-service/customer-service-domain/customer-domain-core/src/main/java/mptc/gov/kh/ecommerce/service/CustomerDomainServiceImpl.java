package mptc.gov.kh.ecommerce.service;

import mptc.gov.kh.ecommerce.domain.valueobject.Email;
import mptc.gov.kh.ecommerce.domain.valueobject.PhoneNumber;
import mptc.gov.kh.ecommerce.entity.Customer;
import mptc.gov.kh.ecommerce.event.CustomerCreatedEvent;
import mptc.gov.kh.ecommerce.event.CustomerDeactivatedEvent;
import mptc.gov.kh.ecommerce.event.CustomerUpdatedEvent;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CustomerDomainServiceImpl implements CustomerDomainService{

    @Override
    public CustomerCreatedEvent validateAndInitiateCustomer(Customer customer) {
        customer.validateCustomer();
        customer.initiateCustomer();
        return new CustomerCreatedEvent(customer, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public CustomerUpdatedEvent updateCustomer(Customer customer, String familyName, String givenName,
                                               Email email, PhoneNumber phoneNumber) {
        customer.updateCustomer(familyName, givenName, email, phoneNumber);
        return new CustomerUpdatedEvent(customer, ZonedDateTime.now(ZoneId.of("UTC")));
    }

    @Override
    public CustomerDeactivatedEvent deactivateCustomer(Customer customer) {
        customer.deactivateCustomer();
        return new CustomerDeactivatedEvent(customer.getId(), ZonedDateTime.now(ZoneId.of("UTC")));
    }

}
