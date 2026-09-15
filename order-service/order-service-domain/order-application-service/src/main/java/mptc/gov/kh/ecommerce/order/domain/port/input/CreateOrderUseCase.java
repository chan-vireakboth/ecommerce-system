package mptc.gov.kh.ecommerce.order.domain.port.input;

import mptc.gov.kh.ecommerce.order.domain.dto.CreateOrderRequest;

public interface CreateOrderUseCase {
    void execute(CreateOrderRequest createOrderRequest);
}
