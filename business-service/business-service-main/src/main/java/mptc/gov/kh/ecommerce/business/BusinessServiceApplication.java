package mptc.gov.kh.ecommerce.business;

import mptc.gov.kh.ecommerce.business.persistence.entity.BusinessEntity;
import mptc.gov.kh.ecommerce.business.persistence.repository.BusinessJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
@EntityScan(basePackages = {"mptc.gov.kh.ecommerce.business.persistence"})
@EnableJpaRepositories(basePackages = {"mptc.gov.kh.ecommerce.business.persistence"})
@SpringBootApplication
public class BusinessServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusinessServiceApplication.class, args);
    }
}
