package mptc.gov.kh.ecommerce.customer.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mptc.gov.kh.ecommerce.customer.domain.dto.CustomerResult;
import mptc.gov.kh.ecommerce.customer.domain.dto.GetCustomerByIdQuery;
import mptc.gov.kh.ecommerce.customer.domain.exception.CustomerNotFoundException;
import mptc.gov.kh.ecommerce.customer.domain.port.output.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class GetCustomerByIdUseCase {

    private final CustomerRepository customerRepository;

    public CustomerResult execute(GetCustomerByIdQuery query) {
        log.info("Execute GetCustomerByIdUseCase : {}", query);

        return customerRepository.findCustomerById(query)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found: " + query.customerId()));
    }
}