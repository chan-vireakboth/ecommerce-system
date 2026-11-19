package mptc.gov.kh.ecommerce.customer.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mptc.gov.kh.ecommerce.customer.domain.dto.CustomerResult;
import mptc.gov.kh.ecommerce.customer.domain.dto.UpdateCustomerCommand;
import mptc.gov.kh.ecommerce.customer.domain.dto.UpdateCustomerResult;
import mptc.gov.kh.ecommerce.customer.domain.mapper.CustomerDataMapper;
import mptc.gov.kh.ecommerce.customer.domain.port.output.CustomerRepository;
import mptc.gov.kh.ecommerce.domain.valueobject.CustomerId;
import mptc.gov.kh.ecommerce.domain.valueobject.Email;
import mptc.gov.kh.ecommerce.domain.valueobject.PhoneNumber;
import mptc.gov.kh.ecommerce.entity.Customer;
import mptc.gov.kh.ecommerce.event.CustomerUpdatedEvent;
import mptc.gov.kh.ecommerce.exception.CustomerDomainException;
import mptc.gov.kh.ecommerce.service.CustomerDomainService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

// Use case: change an existing customer's name, email and phone number.
// Called by the REST API controller (PUT /api/v1/customers/{customerId}).
// Flow: load customer -> check new email -> domain updates -> save -> return id
@Component
@Slf4j
@RequiredArgsConstructor
public class UpdateCustomerUseCase {

    private final CustomerDomainService customerDomainService;
    private final CustomerRepository customerRepository;
    private final CustomerDataMapper customerDataMapper;

    @Transactional
    public UpdateCustomerResult execute(UpdateCustomerCommand updateCustomerCommand) {

        Customer customer = customerRepository.findById(new CustomerId(updateCustomerCommand.customerId()))
                .orElseThrow(() -> new CustomerDomainException(
                        "Customer not found: " + updateCustomerCommand.customerId()));

        Email newEmail = new Email(updateCustomerCommand.email());

        if (!newEmail.equals(customer.getEmail()) && customerRepository.existsByEmail(newEmail.value())) {
            throw new CustomerDomainException("Email already exists");
        }

        customer.updateCustomer(
                updateCustomerCommand.familyName(),
                updateCustomerCommand.givenName(),
                newEmail,
                new PhoneNumber(updateCustomerCommand.phoneNumber())
        );

        CustomerUpdatedEvent customerUpdatedEvent = customerDomainService.updateCustomer(customer);
        CustomerResult savedCustomer = customerRepository.save(customer);

        log.info("Customer updated with id: {} at {}",
                savedCustomer.id(), customerUpdatedEvent.getUpdatedAt());
        return new UpdateCustomerResult(savedCustomer.id());
    }
}