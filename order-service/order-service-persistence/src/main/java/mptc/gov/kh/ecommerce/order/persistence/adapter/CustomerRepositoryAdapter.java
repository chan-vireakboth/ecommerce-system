package mptc.gov.kh.ecommerce.order.persistence.adapter;

import lombok.RequiredArgsConstructor;
import mptc.gov.kh.ecommerce.order.domain.entity.Customer;
import mptc.gov.kh.ecommerce.order.domain.port.output.CustomerRepository;
import mptc.gov.kh.ecommerce.order.persistence.mapper.OrderPersistenceMapper;
import mptc.gov.kh.ecommerce.order.persistence.repository.CustomerJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryAdapter implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    public Optional<Customer> findCustomer(UUID customerID) {
        return customerJpaRepository.findById(customerID).map(orderPersistenceMapper::customerEntityToCustomer);
    }
}
