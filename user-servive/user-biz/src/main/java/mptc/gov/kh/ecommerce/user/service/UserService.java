package mptc.gov.kh.ecommerce.user.service;

import mptc.gov.kh.ecommerce.user.dto.UserCreateRequest;
import mptc.gov.kh.ecommerce.user.dto.UserResponse;
import mptc.gov.kh.ecommerce.user.dto.UserUpdateRequest;

public interface UserService {
    UserResponse create(UserCreateRequest userCreateRequest);

    UserResponse update(String id, UserUpdateRequest userUpdateRequest);

    UserResponse getById(String id);
}
