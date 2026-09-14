package mptc.gov.kh.ecommerce.domain.port.output;

import mptc.gov.kh.ecommerce.domain.entity.Order;

public interface OrderRepository {
    Order saveOrder(Order order);
}
