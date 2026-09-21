package mptc.gov.kh.ecommerce.order.domain.port.input;

import mptc.gov.kh.ecommerce.order.domain.dto.CreateOrderCommand;

public interface ExplicitPort {
    void execute(CreateOrderCommand createOrderCommand);
}
