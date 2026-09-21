package mptc.gov.kh.ecommerce.order.domain.dto;

import mptc.gov.kh.ecommerce.domain.valueobject.BusinessId;
import mptc.gov.kh.ecommerce.domain.valueobject.CustomerId;
import mptc.gov.kh.ecommerce.domain.valueobject.Money;
import mptc.gov.kh.ecommerce.domain.valueobject.StreetAddress;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record CreateOrderCommand(
        UUID customerId,
        UUID businessId,
        BigDecimal price,
        CommandOrderAddress deliveryAddress,
        List<CommandOrderItem> items
) {

}
