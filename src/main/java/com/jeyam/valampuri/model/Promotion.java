package com.jeyam.valampuri.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "promotions")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PromotionType promotionType;

    private String description;

    @Column(nullable = true)
    private BigDecimal discountAmount;

    @Column(nullable = true)
    private Double discountPercentage;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_sk_ids", nullable = true)
    private Set<ProductSku> productSkus;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_ids", nullable = true)
    private Set<Product> products;

    @Column(nullable = true)
    private Double minimumOrderAmount;

}

