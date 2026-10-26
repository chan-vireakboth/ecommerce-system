package mptc.gov.kh.ecommerce.user.service.impl;

import lombok.RequiredArgsConstructor;
import mptc.gov.kh.ecommerce.user.dto.UserCreateRequest;
import mptc.gov.kh.ecommerce.user.dto.UserResponse;
import mptc.gov.kh.ecommerce.user.repository.UserRepository;
import mptc.gov.kh.ecommerce.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {
        return null;
    }
}
