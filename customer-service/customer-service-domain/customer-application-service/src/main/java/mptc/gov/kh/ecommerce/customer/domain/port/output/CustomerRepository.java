package mptc.gov.kh.ecommerce.customer.domain.port.output;


import mptc.gov.kh.ecommerce.domain.valueobject.CustomerId;
import mptc.gov.kh.ecommerce.entity.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(CustomerId customerId);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
