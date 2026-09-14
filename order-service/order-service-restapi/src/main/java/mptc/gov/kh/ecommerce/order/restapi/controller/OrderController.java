package mptc.gov.kh.ecommerce.order.restapi.controller;

import jakarta.validation.Valid;
import mptc.gov.kh.ecommerce.order.restapi.dto.OrderCreateRequest;
import mptc.gov.kh.ecommerce.order.restapi.dto.OrderCreateResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public OrderCreateResponse createOrder(
            @Valid @RequestBody OrderCreateRequest orderCreateRequest
    ){
        return OrderCreateResponse.builder()
                .orderId(UUID.randomUUID())
                .build();
    }
}
