package mptc.gov.kh.ecommerce.customer.domain.port.output;


import mptc.gov.kh.ecommerce.core.PageResponse;
import mptc.gov.kh.ecommerce.customer.domain.dto.CustomerResult;
import mptc.gov.kh.ecommerce.customer.domain.dto.GetCustomerByIdQuery;
import mptc.gov.kh.ecommerce.domain.valueobject.CustomerId;
import mptc.gov.kh.ecommerce.entity.Customer;

import java.util.Optional;

public interface CustomerRepository {

    PageResponse<CustomerResult> findAll(int page, int size);
    Optional<CustomerResult> findCustomerById(GetCustomerByIdQuery query);
    Customer save(Customer customer);
    Optional<Customer> findById(CustomerId customerId);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
