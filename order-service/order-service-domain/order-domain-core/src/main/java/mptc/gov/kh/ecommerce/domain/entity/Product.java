package mptc.gov.kh.ecommerce.domain.entity;

import mptc.gov.kh.ecommerce.domain.valueobject.Money;
import mptc.gov.kh.ecommerce.domain.valueobject.OrderItemId;
import mptc.gov.kh.ecommerce.domain.valueobject.ProductId;

public class Product extends BaseEntity<ProductId> {
    private final String name;
    private final Money price;

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    private Product(Builder builder) {
        //super.setId();
        name = builder.name;
        price = builder.price;
    }


    public static final class Builder {
        private OrderItemId id;
        private String name;
        private Money price;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(OrderItemId val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
