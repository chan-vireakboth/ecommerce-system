package mptc.gov.kh.ecommerce.user.repository;

import mptc.gov.kh.ecommerce.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    boolean existsByUsername(String username);
}
