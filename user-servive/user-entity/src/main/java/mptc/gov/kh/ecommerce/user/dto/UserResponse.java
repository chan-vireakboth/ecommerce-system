package mptc.gov.kh.ecommerce.user.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record UserResponse(
        String id,
        String familyName,
        String givenName,
        String gender,
        Date birthday,
        String mobilePhone,
        String address
) {
}
