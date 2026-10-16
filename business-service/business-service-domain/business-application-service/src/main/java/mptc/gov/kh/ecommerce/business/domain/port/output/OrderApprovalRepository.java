package mptc.gov.kh.ecommerce.business.domain.port.output;

import mptc.gov.kh.ecommerce.business.domain.entity.OrderApproval;

public interface OrderApprovalRepository {

    OrderApproval save(OrderApproval orderApproval);

}
