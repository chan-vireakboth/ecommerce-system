package mptc.gov.kh.ecommerce.user.service;

import mptc.gov.kh.ecommerce.user.dto.UserCreateRequest;
import mptc.gov.kh.ecommerce.user.dto.UserResponse;

public interface UserService {
    UserResponse create(UserCreateRequest userCreateRequest);
}
