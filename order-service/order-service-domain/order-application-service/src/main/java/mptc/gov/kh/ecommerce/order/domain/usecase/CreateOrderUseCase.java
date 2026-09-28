package mptc.gov.kh.ecommerce.order.domain.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mptc.gov.kh.ecommerce.domain.valueobject.BusinessId;
import mptc.gov.kh.ecommerce.domain.valueobject.Money;
import mptc.gov.kh.ecommerce.domain.valueobject.ProductId;
import mptc.gov.kh.ecommerce.order.domain.dto.CreateOrderCommand;
import mptc.gov.kh.ecommerce.order.domain.dto.CreateOrderResult;
import mptc.gov.kh.ecommerce.order.domain.entity.Business;
import mptc.gov.kh.ecommerce.order.domain.entity.Order;
import mptc.gov.kh.ecommerce.order.domain.entity.Product;
import mptc.gov.kh.ecommerce.order.domain.event.OrderCreatedEvent;
import mptc.gov.kh.ecommerce.order.domain.exception.OrderDomainException;
import mptc.gov.kh.ecommerce.order.domain.mapper.OrderDomainMapper;
import mptc.gov.kh.ecommerce.order.domain.port.output.BusinessRepository;
import mptc.gov.kh.ecommerce.order.domain.port.output.CustomerRepository;
import mptc.gov.kh.ecommerce.order.domain.port.output.OrderRepository;
import mptc.gov.kh.ecommerce.order.domain.service.OrderDomainService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateOrderUseCase {

    private final OrderDomainService orderDomainService;
    private final OrderDomainMapper orderDomainMapper;

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final BusinessRepository businessRepository;

    @Transactional
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

        // Invoke order domain logic
        Order order = orderDomainMapper.createOrderCommandToOrder(createOrderCommand);
        log.info("Order price: {}", order.getPrice().amount());
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, business);
        log.info("Order created event: {}", orderCreatedEvent.getOrder().getId());

        //Save order into database
        Order savedOrder = orderRepository.saveOrder(order);
        if (savedOrder == null) {
            throw new OrderDomainException("Could not save order into database");
        }

        return new CreateOrderResult(savedOrder.getId().value());
    }

}

//INSERT, UDPDATE, DELETE -> Command -> TRANSACTION
//SELECT -> Query -> TRANSACTION READ ONLY
//Pattern: CQRS = Command Query Responsibility Segregation
