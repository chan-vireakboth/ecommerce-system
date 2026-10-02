package mptc.gov.kh.ecommerce.payment.domain.port.output;

import mptc.gov.kh.ecommerce.payment.domain.entity.CreditHistory;

public interface CreditHistoryRepository {
    CreditHistory save(CreditHistory creditHistory);
}
