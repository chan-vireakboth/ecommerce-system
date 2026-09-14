package mptc.gov.kh.ecommerce.domain.dto;

import mptc.gov.kh.ecommerce.domain.valueobject.BusinessId;
import mptc.gov.kh.ecommerce.domain.valueobject.CustomerId;
import mptc.gov.kh.ecommerce.domain.valueobject.Money;
import mptc.gov.kh.ecommerce.domain.valueobject.StreetAddress;

public record CreateOrderRequest(
        CustomerId customerId,
        BusinessId businessId,
        StreetAddress deliveryAddress,
        Money money
) {

}
