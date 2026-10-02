package mptc.gov.kh.ecommerce.business.domain.event;

import mptc.gov.kh.ecommerce.business.domain.entity.OrderApproval;
import mptc.gov.kh.ecommerce.domain.valueobject.BusinessId;

import java.time.ZonedDateTime;
import java.util.List;

public class OrderRejectedEvent extends OrderApprovalEvent {
    public OrderRejectedEvent(OrderApproval orderApproval, BusinessId businessId, List<String> failureMessages, ZonedDateTime createdAt) {
        super(orderApproval, businessId, failureMessages, createdAt);
    }
}
