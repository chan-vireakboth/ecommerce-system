package mptc.gov.kh.ecommerce.order.restapi.mapper;

import mptc.gov.kh.ecommerce.order.domain.dto.CreateOrderCommand;
import mptc.gov.kh.ecommerce.order.domain.dto.CreateOrderResult;
import mptc.gov.kh.ecommerce.order.restapi.dto.OrderCreateRequest;
import mptc.gov.kh.ecommerce.order.restapi.dto.OrderCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderWebMapper {
    //Source = OrderCreateRequest
    //Target = CreateOrderCommand
    @Mapping(source = "orderAddress", target = "deliveryAddress")
    CreateOrderCommand orderCreateRequesttoCreateOrderCommand(OrderCreateRequest orderCreateRequest);

    OrderCreateResponse createOrderResultToOrderCreateResponse(CreateOrderResult createOrderResult);
}
