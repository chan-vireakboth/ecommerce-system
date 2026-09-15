package mptc.gov.kh.ecommerce.order.domain.event;

import mptc.gov.kh.ecommerce.order.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderCreatedEvent extends OrderEvent{
    public OrderCreatedEvent(Order order, ZonedDateTime createdAt) {
        super(order, createdAt);
    }
}
