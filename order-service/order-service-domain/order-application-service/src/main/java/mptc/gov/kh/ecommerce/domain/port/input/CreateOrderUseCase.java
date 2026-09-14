package mptc.gov.kh.ecommerce.domain.port.input;

import mptc.gov.kh.ecommerce.domain.dto.CreateOrderRequest;

public interface CreateOrderUseCase {
    void execute(CreateOrderRequest createOrderRequest);
}
