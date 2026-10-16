package mptc.gov.kh.ecommerce.business.domain.port.output;

import mptc.gov.kh.ecommerce.business.domain.entity.Business;

import java.util.Optional;

public interface BusinessRepository {

    Optional<Business> findBusinessInformation(Business business);

}
