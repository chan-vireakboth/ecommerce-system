package mptc.gov.kh.ecommerce.payment.domain.service;

import mptc.gov.kh.ecommerce.domain.valueobject.PaymentStatus;
import mptc.gov.kh.ecommerce.payment.domain.entity.CreditEntry;
import mptc.gov.kh.ecommerce.payment.domain.entity.CreditHistory;
import mptc.gov.kh.ecommerce.payment.domain.entity.Payment;

public interface PaymentDomainService {
  CreditHistory validateAndInitiatePayment(Payment payment, CreditEntry creditEntry);

  void updatePaymentStatus(Payment payment, PaymentStatus newPaymentStatus);
}
