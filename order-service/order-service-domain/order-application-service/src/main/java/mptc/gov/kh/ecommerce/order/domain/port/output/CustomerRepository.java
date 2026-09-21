package mptc.gov.kh.ecommerce.order.domain.port.output;

import mptc.gov.kh.ecommerce.order.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Optional<Customer> findCustomer(UUID customerID);
}
