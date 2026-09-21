package mptc.gov.kh.ecommerce.order.restapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mptc.gov.kh.ecommerce.order.domain.dto.CreateOrderCommand;
import mptc.gov.kh.ecommerce.order.domain.dto.CreateOrderResult;
import mptc.gov.kh.ecommerce.order.domain.usecase.CreateOrderUseCase;
import mptc.gov.kh.ecommerce.order.restapi.dto.OrderCreateRequest;
import mptc.gov.kh.ecommerce.order.restapi.dto.OrderCreateResponse;
import mptc.gov.kh.ecommerce.order.restapi.mapper.OrderWebMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderCommandController {

    //Declare required dependencies
    private final CreateOrderUseCase createOrderUseCase;
    private final OrderWebMapper orderWebMapper;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public OrderCreateResponse createOrder(
            @Valid @RequestBody OrderCreateRequest orderCreateRequest
    ){
        //Mapping logic
        CreateOrderCommand createOrderCommand = orderWebMapper.orderCreateRequesttoCreateOrderCommand(orderCreateRequest);

        //UseCase logic
        CreateOrderResult createOrderResult = createOrderUseCase.execute(createOrderCommand);

        //Mapping logic
        return orderWebMapper.createOrderResultToOrderCreateResponse(createOrderResult);
    }
}
