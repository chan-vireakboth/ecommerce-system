package mptc.gov.kh.ecommerce.order.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mptc.gov.kh.ecommerce.domain.valueobject.BusinessId;
import mptc.gov.kh.ecommerce.domain.valueobject.Money;
import mptc.gov.kh.ecommerce.domain.valueobject.ProductId;
import mptc.gov.kh.ecommerce.order.domain.dto.CreateOrderCommand;
import mptc.gov.kh.ecommerce.order.domain.dto.CreateOrderResult;
import mptc.gov.kh.ecommerce.order.domain.entity.Business;
import mptc.gov.kh.ecommerce.order.domain.entity.Product;
import mptc.gov.kh.ecommerce.order.domain.exception.OrderDomainException;
import mptc.gov.kh.ecommerce.order.domain.port.output.BusinessRepository;
import mptc.gov.kh.ecommerce.order.domain.port.output.CustomerRepository;
import mptc.gov.kh.ecommerce.order.domain.port.output.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateOrderUseCase {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final BusinessRepository businessRepository;

    public CreateOrderResult execute(CreateOrderCommand createOrderCommand) {
        log.info("executing CreateOrderUseCase: {}", createOrderCommand);

        //Validate customer
        customerRepository.findCustomer(createOrderCommand.customerId())
                .orElseThrow(() -> new OrderDomainException("Could not find customer with ID: " + createOrderCommand.customerId()));

        //Validate business
        List<Product> products = createOrderCommand.items().stream()
                .map(commandOrderItem -> Product.builder()
                        .id(new ProductId(commandOrderItem.productId()))
                        .price(new Money(commandOrderItem.price()))
                        .build())
                .toList();

        Business business = Business.builder()
                .id(new BusinessId(createOrderCommand.businessId()))
                .products(products)
                .build();

        business = businessRepository.findBusiness(business)
                .orElseThrow(() -> new OrderDomainException("Could not find business with ID: " + createOrderCommand.businessId()));

        log.info("Found business: {}", business);

        return new CreateOrderResult(UUID.randomUUID());
    }

}

//INSERT, UDPDATE, DELETE -> Command -> TRANSACTION
//SELECT -> Query -> TRANSACTION READ ONLY
//Pattern: CQRS = Command Query Responsibility Segregation
