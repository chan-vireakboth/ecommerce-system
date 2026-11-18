package mptc.gov.kh.ecommerce.customer.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mptc.gov.kh.ecommerce.core.PageResponse;
import mptc.gov.kh.ecommerce.customer.domain.dto.CustomerResult;
import mptc.gov.kh.ecommerce.customer.domain.dto.GetCustomersQuery;
import mptc.gov.kh.ecommerce.customer.domain.port.output.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class GetAllCustomerUseCase {

    private final CustomerRepository customerRepository;

     public PageResponse<CustomerResult> execute(GetCustomersQuery query){
        log.info("Execute GetAllCustomerUseCase : {}", query);
        return customerRepository.findAll(query.page(), query.size());
    }
}
