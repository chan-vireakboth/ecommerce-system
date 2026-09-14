package mptc.gov.kh.ecommerce.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mptc.gov.kh.ecommerce.domain.valueobject.OrderStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

//JPA Entity must be POJO (Plan Old Java Object) Class
@Getter
@Setter
@NoArgsConstructor
@Entity //ORM: Create table name
@Table(name = "orders") //Change table name
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID customerId;

    private UUID businessId;

    private BigDecimal price;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> items;

    @OneToOne
    private OrderAddressEntity orderAddress;

    private UUID trackingId;

    private OrderStatus orderStatus;

    private String failureMessage; //message1; message2
}
