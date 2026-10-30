package mptc.gov.kh.ecommerce.user.service;

import mptc.gov.kh.ecommerce.user.dto.UserCreateRequest;
import mptc.gov.kh.ecommerce.user.dto.UserResponse;
import mptc.gov.kh.ecommerce.user.dto.UserUpdateRequest;

import java.util.List;

public interface UserService {
    UserResponse create(UserCreateRequest userCreateRequest);

    UserResponse update(String id, UserUpdateRequest userUpdateRequest);

    UserResponse getUserById(String id);

    UserResponse getUserByUsername(String username);

    List<UserResponse> getUsers();

    List<UserResponse> getUsersByRoleName(String roleName);

    void delete(String id);
}
