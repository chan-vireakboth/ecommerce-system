package mptc.gov.kh.ecommerce.order.domain.port.output;

import mptc.gov.kh.ecommerce.order.domain.entity.Business;

import java.util.Optional;
import java.util.UUID;

public interface BusinessRepository {
    Optional<Business> findBusiness(UUID businessId);
}
