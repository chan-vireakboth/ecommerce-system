package mptc.gov.kh.ecommerce.payment.domain.dto;

import mptc.gov.kh.ecommerce.domain.valueobject.PaymentStatus;

import java.util.UUID;

public record CreatePaymentResult(
    UUID paymentId,
    PaymentStatus paymentStatus
) {
}
