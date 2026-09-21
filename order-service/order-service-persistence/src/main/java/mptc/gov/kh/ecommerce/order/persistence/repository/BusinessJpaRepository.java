package mptc.gov.kh.ecommerce.order.persistence.repository;

import io.micrometer.observation.ObservationFilter;
import mptc.gov.kh.ecommerce.order.persistence.entity.BusinessEntity;
import mptc.gov.kh.ecommerce.order.persistence.entity.BusinessIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BusinessJpaRepository extends JpaRepository<BusinessEntity, UUID> {
}
