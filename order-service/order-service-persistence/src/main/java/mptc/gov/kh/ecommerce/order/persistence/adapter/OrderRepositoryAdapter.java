package mptc.gov.kh.ecommerce.order.persistence.adapter;

import lombok.RequiredArgsConstructor;
import mptc.gov.kh.ecommerce.order.domain.entity.Order;
import mptc.gov.kh.ecommerce.order.domain.port.output.OrderRepository;
import mptc.gov.kh.ecommerce.order.persistence.entity.OrderEntity;
import mptc.gov.kh.ecommerce.order.persistence.mapper.OrderPersistenceMapper;
import mptc.gov.kh.ecommerce.order.persistence.repository.OrderJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    public Order saveOrder(Order order) {
        //Map Order to OrderEntity
        OrderEntity orderEntity = orderPersistenceMapper.orderToOrderEntity(order);
        //Save into database
        orderEntity = orderJpaRepository.save(orderEntity);
        //Map OrderEntity to Order
        return orderPersistenceMapper.orderEntityToOrder(orderJpaRepository.save(orderEntity));
    }
}
