package mptc.gov.kh.ecommerce.order.persistence.mapper;

import mptc.gov.kh.ecommerce.domain.valueobject.BusinessId;
import mptc.gov.kh.ecommerce.order.domain.entity.Business;
import mptc.gov.kh.ecommerce.order.domain.entity.Customer;
import mptc.gov.kh.ecommerce.order.domain.entity.Product;
import mptc.gov.kh.ecommerce.order.persistence.entity.BusinessEntity;
import mptc.gov.kh.ecommerce.order.persistence.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderPersistenceMapper {

    @Mapping(source = "id", target = "id.value")
    Customer customerEntityToCustomer(CustomerEntity customerEntity);

    @Mapping(source = "businessId", target = "id.value")
    Business businessEntityToBusiness(BusinessEntity businessEntity);
}
