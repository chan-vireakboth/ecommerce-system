package mptc.gov.kh.ecommerce.service;

import mptc.gov.kh.ecommerce.domain.valueobject.Email;
import mptc.gov.kh.ecommerce.domain.valueobject.PhoneNumber;
import mptc.gov.kh.ecommerce.entity.Customer;
import mptc.gov.kh.ecommerce.event.CustomerCreatedEvent;
import mptc.gov.kh.ecommerce.event.CustomerDeactivatedEvent;
import mptc.gov.kh.ecommerce.event.CustomerUpdatedEvent;


public interface CustomerDomainService {
    CustomerCreatedEvent validateAndInitiateCustomer(Customer customer);

    CustomerUpdatedEvent updateCustomer(Customer customer, String familyName, String givenName,
                                        Email email, PhoneNumber phoneNumber);

    CustomerDeactivatedEvent deactivateCustomer(Customer customer);
}
