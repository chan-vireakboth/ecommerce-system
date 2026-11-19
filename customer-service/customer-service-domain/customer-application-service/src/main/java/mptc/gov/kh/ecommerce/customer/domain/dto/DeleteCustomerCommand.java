package mptc.gov.kh.ecommerce.customer.domain.dto;

import java.util.UUID;

public record DeleteCustomerCommand(
        UUID customerId
) {
}