package mptc.gov.kh.ecommerce.payment.persistence.adapter;

import mptc.gov.kh.ecommerce.domain.valueobject.CustomerId;
import mptc.gov.kh.ecommerce.payment.domain.entity.CreditEntry;
import mptc.gov.kh.ecommerce.payment.domain.port.output.CreditEntityRepository;
import mptc.gov.kh.ecommerce.payment.persistence.entity.CreditEntryEntity;
import mptc.gov.kh.ecommerce.payment.persistence.mapper.CreditEntryPersistenceMapper;
import mptc.gov.kh.ecommerce.payment.persistence.repository.CreditEntryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CreditEntryRepositoryAdapter implements CreditEntityRepository {
  private final CreditEntryJpaRepository creditEntryJpaRepository;
  private final CreditEntryPersistenceMapper creditEntryPersistenceMapper;

  @Override
  public CreditEntry findByCustomerId(CustomerId customerId) {
    return creditEntryJpaRepository.findByCustomerId(customerId.value())
        .map(creditEntryPersistenceMapper::creditEntryEntityToCreditEntry)
        .orElse(null);
  }

  @Override
  public CreditEntry save(CreditEntry creditEntry) {
    CreditEntryEntity creditEntryEntity = creditEntryPersistenceMapper.creditEntryToCreditEntryEntity(creditEntry);
    CreditEntryEntity savedCreditEntryEntity = creditEntryJpaRepository.save(creditEntryEntity);
    return creditEntryPersistenceMapper.creditEntryEntityToCreditEntry(savedCreditEntryEntity);
  }
}
