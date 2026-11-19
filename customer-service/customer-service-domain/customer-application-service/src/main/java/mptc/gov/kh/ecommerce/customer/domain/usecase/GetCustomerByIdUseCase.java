package mptc.gov.kh.ecommerce.customer.domain.usecase;

import lombok.RequiredArgsConstructor;
import mptc.gov.kh.ecommerce.customer.domain.dto.CustomerResult;
import mptc.gov.kh.ecommerce.customer.domain.mapper.CustomerDataMapper;
import mptc.gov.kh.ecommerce.customer.domain.port.output.CustomerRepository;
import mptc.gov.kh.ecommerce.domain.valueobject.CustomerId;
import mptc.gov.kh.ecommerce.exception.CustomerDomainException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetCustomerByIdUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerDataMapper customerDataMapper;

    public CustomerResult execute(UUID id) {
        return customerRepository.findByIdWithCache(new CustomerId(id))
                .orElseThrow(() -> new CustomerDomainException("Customer not found"));
    }

}