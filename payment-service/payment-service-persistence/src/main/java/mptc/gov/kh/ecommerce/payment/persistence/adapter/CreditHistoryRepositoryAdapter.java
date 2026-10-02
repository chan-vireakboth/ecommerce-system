package mptc.gov.kh.ecommerce.payment.persistence.adapter;

import mptc.gov.kh.ecommerce.payment.domain.entity.CreditHistory;
import mptc.gov.kh.ecommerce.payment.domain.port.output.CreditHistoryRepository;
import mptc.gov.kh.ecommerce.payment.persistence.entity.CreditHistoryEntity;
import mptc.gov.kh.ecommerce.payment.persistence.mapper.CreditHistoryPersistenceMapper;
import mptc.gov.kh.ecommerce.payment.persistence.repository.CreditHistoryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreditHistoryRepositoryAdapter implements CreditHistoryRepository {
  private final CreditHistoryJpaRepository creditHistoryJpaRepository;
  private final CreditHistoryPersistenceMapper creditHistoryPersistenceMapper;

  @Override
  public CreditHistory save(CreditHistory creditHistory) {
    CreditHistoryEntity creditHistoryEntity =
        creditHistoryPersistenceMapper.creditHistoryToCreditHistoryEntity(creditHistory);
    CreditHistoryEntity savedCreditHistoryEntity = creditHistoryJpaRepository.save(creditHistoryEntity);
    return creditHistoryPersistenceMapper.creditHistoryEntityToCreditHistory(savedCreditHistoryEntity);
  }
}
