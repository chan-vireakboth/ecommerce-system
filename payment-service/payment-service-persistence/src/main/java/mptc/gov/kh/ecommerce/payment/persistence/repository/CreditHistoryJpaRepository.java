package mptc.gov.kh.ecommerce.payment.persistence.repository;

import mptc.gov.kh.ecommerce.payment.persistence.entity.CreditHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreditHistoryJpaRepository extends JpaRepository<CreditHistoryEntity, UUID> {
}
