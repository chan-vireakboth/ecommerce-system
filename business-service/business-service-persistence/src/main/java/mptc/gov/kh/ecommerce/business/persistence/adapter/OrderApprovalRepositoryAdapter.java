package mptc.gov.kh.ecommerce.business.persistence.adapter;

import mptc.gov.kh.ecommerce.business.domain.entity.OrderApproval;
import mptc.gov.kh.ecommerce.business.domain.port.output.OrderApprovalRepository;
import mptc.gov.kh.ecommerce.business.persistence.entity.OrderApprovalEntity;
import mptc.gov.kh.ecommerce.business.persistence.mapper.OrderApprovalPersistenceMapper;
import mptc.gov.kh.ecommerce.business.persistence.repository.OrderApprovalJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderApprovalRepositoryAdapter implements OrderApprovalRepository {

    private final OrderApprovalJpaRepository orderApprovalJpaRepository;
    private final OrderApprovalPersistenceMapper orderApprovalPersistenceMapper;

    @Override
    public OrderApproval save(OrderApproval orderApproval) {
        OrderApprovalEntity orderApprovalEntity = orderApprovalPersistenceMapper.orderApprovalToOrderApprovalEntity(orderApproval);

        return orderApprovalPersistenceMapper.orderApprovalEntityToOrderApproval(orderApprovalJpaRepository.save(orderApprovalEntity));
    }
}
