package mptc.gov.kh.ecommerce.customer.restapi.controller;


import mptc.gov.kh.ecommerce.customer.domain.dto.CreateCustomerCommand;
import mptc.gov.kh.ecommerce.customer.domain.dto.CreateCustomerResult;
import mptc.gov.kh.ecommerce.customer.domain.dto.DeactivateCustomerCommand;
import mptc.gov.kh.ecommerce.customer.domain.dto.UpdateCustomerCommand;
import mptc.gov.kh.ecommerce.customer.domain.dto.UpdateCustomerResult;
import mptc.gov.kh.ecommerce.customer.domain.usecase.CreateCustomerUseCase;
import mptc.gov.kh.ecommerce.customer.domain.usecase.DeactivateCustomerUseCase;
import mptc.gov.kh.ecommerce.customer.domain.usecase.UpdateCustomerUseCase;
import mptc.gov.kh.ecommerce.customer.restapi.dto.CustomerCreateRequest;
import mptc.gov.kh.ecommerce.customer.restapi.dto.CustomerCreateResponse;
import mptc.gov.kh.ecommerce.customer.restapi.dto.CustomerUpdateRequest;
import mptc.gov.kh.ecommerce.customer.restapi.dto.CustomerUpdateResponse;
import mptc.gov.kh.ecommerce.customer.restapi.mapper.CustomerWebMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerCommandController {

    private final CustomerWebMapper customerWebMapper;
    private final CreateCustomerUseCase createCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final DeactivateCustomerUseCase deactivateCustomerUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerCreateResponse createCustomer(@Valid @RequestBody CustomerCreateRequest customerCreateRequest){
        CreateCustomerCommand createCustomerCommand = customerWebMapper.customerCreateRequestToCreateCustomerCommand(customerCreateRequest);
        CreateCustomerResult createCustomerResult = createCustomerUseCase.execute(createCustomerCommand);
        return customerWebMapper.createCustomerResultToCustomerCreateResponse(createCustomerResult);
    }

    @PutMapping("/{customerId}")
    public CustomerUpdateResponse updateCustomer(@PathVariable UUID customerId,
                                                 @Valid @RequestBody CustomerUpdateRequest customerUpdateRequest){
        UpdateCustomerCommand updateCustomerCommand = customerWebMapper.customerUpdateRequestToUpdateCustomerCommand(customerId, customerUpdateRequest);
        UpdateCustomerResult updateCustomerResult = updateCustomerUseCase.execute(updateCustomerCommand);
        return customerWebMapper.updateCustomerResultToCustomerUpdateResponse(updateCustomerResult);
    }

    @PatchMapping("/{customerId}/deactivate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivateCustomer(@PathVariable UUID customerId){
        deactivateCustomerUseCase.execute(new DeactivateCustomerCommand(customerId));
    }

}
