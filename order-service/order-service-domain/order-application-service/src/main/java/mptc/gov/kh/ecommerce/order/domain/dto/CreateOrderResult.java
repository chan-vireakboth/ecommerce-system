package mptc.gov.kh.ecommerce.order.domain.dto;

import mptc.gov.kh.ecommerce.domain.valueobject.OrderId;

import java.util.UUID;

public record CreateOrderResult(UUID orderId) {
}
