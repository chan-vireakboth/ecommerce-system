package mptc.gov.kh.ecommerce.order.persistence.repository;

import mptc.gov.kh.ecommerce.order.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

//Benefit os using Spring Data JPA
//1. Boilerplate core
//2.Abstraction Repository
//3.Derived Query Method (Auto generate SQL)
//4.Object Relational Mapping (ORM) Hibernate
//5. Specification (Dynamic Query)


public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {
}
