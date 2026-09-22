package mptc.gov.kh.ecommerce.order.persistence.mapper;

import mptc.gov.kh.ecommerce.order.domain.entity.Customer;
import mptc.gov.kh.ecommerce.order.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerPersistenceMapper {
    @Mapping(source = "id", target = "id.value")
    Customer customerEntityToCustomer(CustomerEntity customerEntity);
}
