package mptc.gov.kh.ecommerce.order.domain.port.output;

import mptc.gov.kh.ecommerce.order.domain.entity.Order;

public interface OrderRepository {
    Order saveOrder(Order order);
}
