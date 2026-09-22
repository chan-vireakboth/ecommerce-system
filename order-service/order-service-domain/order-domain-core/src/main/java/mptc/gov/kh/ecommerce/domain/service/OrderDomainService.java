package mptc.gov.kh.ecommerce.domain.service;

import mptc.gov.kh.ecommerce.order.domain.entity.Business;
import mptc.gov.kh.ecommerce.order.domain.entity.Order;
import mptc.gov.kh.ecommerce.order.domain.event.OrderCancelledEvent;
import mptc.gov.kh.ecommerce.order.domain.event.OrderCreatedEvent;
import mptc.gov.kh.ecommerce.order.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Business business);

    OrderPaidEvent payOrder(Order order);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

    void cancelOrder(Order order, List<String> failureMessages);
}