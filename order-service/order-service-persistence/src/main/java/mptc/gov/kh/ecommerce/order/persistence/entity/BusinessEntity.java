package mptc.gov.kh.ecommerce.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mptc.gov.kh.ecommerce.domain.entity.Product;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "businesses")
@IdClass(BusinessIdEntity.class) //Composite Primary Key
public class BusinessEntity {
    @Id
    private UUID businessId;

    @Id
    private UUID productId;

    private Boolean active;
    private String productName;
    private BigDecimal productPrice;
}
