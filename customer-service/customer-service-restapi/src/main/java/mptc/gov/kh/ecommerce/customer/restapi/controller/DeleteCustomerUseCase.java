package mptc.gov.kh.ecommerce.customer.restapi.controller;

import lombok.RequiredArgsConstructor;
import mptc.gov.kh.ecommerce.customer.domain.dto.DeleteCustomerCommand;
import mptc.gov.kh.ecommerce.customer.domain.port.output.CustomerRepository;
import mptc.gov.kh.ecommerce.domain.valueobject.CustomerId;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCustomerUseCase {

    private final CustomerRepository customerRepository;

    public void execute(DeleteCustomerCommand deleteCustomerCommand) {
        CustomerId customerId = new CustomerId(deleteCustomerCommand.customerId());
        customerRepository.deleteById(customerId);
    }

}