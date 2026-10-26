package mptc.gov.kh.ecommerce.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"mptc.gov.kh.ecommerce.payment.persistence"})
@EntityScan(basePackages = {"mptc.gov.kh.ecommerce.payment.persistence"})
@SpringBootApplication(scanBasePackages = {"mptc.gov.kh.ecommerce.payment.persistence"})
public class PaymentApplicationService {
  static void main(String[] args) {
    SpringApplication.run(PaymentApplicationService.class, args);
  }
}
