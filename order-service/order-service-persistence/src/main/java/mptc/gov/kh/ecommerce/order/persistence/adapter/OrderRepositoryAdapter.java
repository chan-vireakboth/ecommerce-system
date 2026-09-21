package mptc.gov.kh.ecommerce.order.persistence.adapter;

import lombok.RequiredArgsConstructor;
import mptc.gov.kh.ecommerce.order.domain.entity.Order;
import mptc.gov.kh.ecommerce.order.domain.port.output.OrderRepository;
import mptc.gov.kh.ecommerce.order.persistence.repository.OrderJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order saveOrder(Order order) {
        //Map Order to OrderEntity
        //Map OrderEntity to Order
        return null;
    }
}
