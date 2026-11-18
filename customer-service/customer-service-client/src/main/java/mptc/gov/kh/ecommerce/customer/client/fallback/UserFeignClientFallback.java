package mptc.gov.kh.ecommerce.customer.client.fallback;

import lombok.extern.slf4j.Slf4j;
import mptc.gov.kh.ecommerce.customer.client.dto.UserResponse;
import mptc.gov.kh.ecommerce.customer.client.exception.UserServiceUnavailableException;
import mptc.gov.kh.ecommerce.customer.client.feign.UserFeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserFeignClientFallback implements UserFeignClient {



    @Override
    public UserResponse getById(String id) {
        log.error("UserFeignClientFallback: getById: {}", id);

        throw new UserServiceUnavailableException("User Service is unavailable now. Please try again.");
    }
}
