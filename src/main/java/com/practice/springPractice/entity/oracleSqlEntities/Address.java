package com.practice.springPractice.entity.oracleSqlEntities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "customer_customer_id")
    private Customer customer;

    @Column(name = "line", nullable = false)
    private String line;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "pincode", nullable = false, unique = true)
    private Long pincode;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "country")
    private String country="India";

}