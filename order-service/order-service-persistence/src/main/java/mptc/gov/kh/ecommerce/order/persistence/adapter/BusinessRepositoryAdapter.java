package mptc.gov.kh.ecommerce.order.persistence.adapter;


import lombok.RequiredArgsConstructor;
import mptc.gov.kh.ecommerce.order.domain.entity.Business;
import mptc.gov.kh.ecommerce.order.domain.port.output.BusinessRepository;
import mptc.gov.kh.ecommerce.order.persistence.mapper.OrderPersistenceMapper;
import mptc.gov.kh.ecommerce.order.persistence.repository.BusinessJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class BusinessRepositoryAdapter implements BusinessRepository {

    private final BusinessJpaRepository businessJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;


    @Override
    public Optional<Business> findBusiness(UUID businessId) {
        return businessJpaRepository.findById(businessId).map(orderPersistenceMapper::businessEntityToBusiness);
    }
}
