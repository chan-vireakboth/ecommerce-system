package mptc.gov.kh.ecommerce.payment.persistence.adapter;

import mptc.gov.kh.ecommerce.payment.domain.entity.Payment;
import mptc.gov.kh.ecommerce.payment.domain.port.output.PaymentRepository;
import mptc.gov.kh.ecommerce.payment.persistence.entity.PaymentEntity;
import mptc.gov.kh.ecommerce.payment.persistence.mapper.PaymentPersistenceMapper;
import mptc.gov.kh.ecommerce.payment.persistence.repository.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryAdapter implements PaymentRepository {
  private final PaymentJpaRepository paymentJpaRepository;
  private final PaymentPersistenceMapper paymentPersistenceMapper;

  @Override
  public Payment savePayment(Payment payment) {
    PaymentEntity paymentEntity = paymentPersistenceMapper.paymentToPaymentEntity(payment);
    PaymentEntity savedPaymentEntity = paymentJpaRepository.save(paymentEntity);
    return paymentPersistenceMapper.paymentEntityToPayment(savedPaymentEntity);
  }
}
