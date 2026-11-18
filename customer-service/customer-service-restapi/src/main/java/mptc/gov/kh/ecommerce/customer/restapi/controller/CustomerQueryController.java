package mptc.gov.kh.ecommerce.customer.restapi.controller;

import lombok.RequiredArgsConstructor;
import mptc.gov.kh.ecommerce.core.PageResponse;
import mptc.gov.kh.ecommerce.customer.client.dto.UserResponse;
import mptc.gov.kh.ecommerce.customer.client.feign.UserFeignClient;
import mptc.gov.kh.ecommerce.customer.domain.dto.CustomerResult;
import mptc.gov.kh.ecommerce.customer.domain.dto.GetCustomerByIdQuery;
import mptc.gov.kh.ecommerce.customer.domain.dto.GetCustomersQuery;
import mptc.gov.kh.ecommerce.customer.domain.usecase.GetAllCustomerUseCase;
import mptc.gov.kh.ecommerce.customer.domain.usecase.GetCustomerByIdUseCase;
import mptc.gov.kh.ecommerce.customer.restapi.dto.CustomerResponse;
import mptc.gov.kh.ecommerce.customer.restapi.mapper.CustomerWebMapper;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerQueryController {

    private final UserFeignClient userFeignClient;
    private final GetAllCustomerUseCase getAllCustomerUseCase;
    private final GetCustomerByIdUseCase getCustomerByIdUseCase;
    private final CustomerWebMapper customerWebMapper;

    @GetMapping
    public PageResponse<CustomerResponse> getAll(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "25") int size
    ){
       PageResponse<CustomerResult> result = getAllCustomerUseCase.execute(new GetCustomersQuery(page, size));
       return customerWebMapper.toCustomerResponse(result);
    }

    @GetMapping("/{customerId}")
    public CustomerResponse getById(@PathVariable UUID customerId) {
        CustomerResult result = getCustomerByIdUseCase.execute(new GetCustomerByIdQuery(customerId));
        return customerWebMapper.toCustomerResponse(result);
    }

    @GetMapping("/check-user/{userId}")
    public UserResponse checkUser(@PathVariable String userId){
        return userFeignClient.getById(userId);
    }

}
