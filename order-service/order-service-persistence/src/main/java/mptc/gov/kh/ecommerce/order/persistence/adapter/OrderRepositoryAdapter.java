package mptc.gov.kh.ecommerce.order.persistence.adapter;

import mptc.gov.kh.ecommerce.domain.entity.Order;
import mptc.gov.kh.ecommerce.domain.port.output.OrderRepository;
import mptc.gov.kh.ecommerce.order.persistence.repository.OrderJpaRepository;

public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    public OrderRepositoryAdapter(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        //Map Order to OrderEntity
        //Map OrderEntity to Order
        return null;
    }
}
