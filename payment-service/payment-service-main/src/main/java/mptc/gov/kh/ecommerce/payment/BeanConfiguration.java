package mptc.gov.kh.ecommerce.payment;

import mptc.gov.kh.ecommerce.payment.domain.service.PaymentDomainService;
import mptc.gov.kh.ecommerce.payment.domain.service.PaymentDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
  @Bean
  public PaymentDomainService paymentDomainService() {
    return new PaymentDomainServiceImpl();
  }
}
