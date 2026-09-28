package mptc.gov.kh.ecommerce.order;

//How to configure bean
//1. Annotated based
//2. Java based configuration (method)

import mptc.gov.kh.ecommerce.order.domain.service.OrderDomainService;
import mptc.gov.kh.ecommerce.order.domain.service.OrderDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public OrderDomainService orderDomainService(){
        return new OrderDomainServiceImpl();
    }

}
