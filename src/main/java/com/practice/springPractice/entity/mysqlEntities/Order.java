package com.practice.springPractice.entity.mysqlEntities;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.practice.springPractice.entity.mysqlEntities.Product;
import com.practice.springPractice.entity.oracleSqlEntities.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import java.util.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_gen")
    @SequenceGenerator(name = "order_gen", sequenceName = "order_seq", initialValue = 100000)
    @Column(name = "order_id", nullable = false)
    private Long orderId;

  /*  @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "customer_customer_id")
    private Customer customer;*/

   /* @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, orphanRemoval = true)
    @JsonIncludeProperties
    private List<Product> products ;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
*/
   /* public Customer getCustomer() {
        return customer;
    }*/

//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
