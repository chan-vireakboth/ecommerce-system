package mptc.gov.kh.ecommerce.order.domain.usecase;

import lombok.extern.slf4j.Slf4j;
import mptc.gov.kh.ecommerce.order.domain.dto.CreateOrderCommand;
import mptc.gov.kh.ecommerce.order.domain.dto.CreateOrderResult;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class CreateOrderUseCase {

    public CreateOrderResult execute(CreateOrderCommand createOrderCommand) {
        log.info("executing CreateOrderUseCase: {}", createOrderCommand);

        //

        return new CreateOrderResult(UUID.randomUUID());
    }

}

//INSERT, UDPDATE, DELETE -> Command -> TRANSACTION
//SELECT -> Query -> TRANSACTION READ ONLY
//Pattern: CQRS = Command Query Responsibility Segregation
