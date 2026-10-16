package mptc.gov.kh.ecommerce.payment.domain.port.output;

import mptc.gov.kh.ecommerce.payment.domain.entity.Payment;

public interface PaymentRepository {
  Payment savePayment(Payment payment);
}
