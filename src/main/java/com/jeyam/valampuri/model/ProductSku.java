package com.jeyam.valampuri.model;

import com.jeyam.valampuri.config.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_skus")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = {"product", "productSkuDetails"})
public class ProductSku extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false, unique = true)
    private String skuCode;

    @OneToOne(mappedBy = "productSku", cascade = CascadeType.ALL,  fetch = FetchType.EAGER)
    private Price price;

    @OneToOne(mappedBy = "productSku", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Stock stock;

    @OneToMany(mappedBy = "productSku", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProcurementHistory> procurementHistories;

    @OneToMany(mappedBy = "productSku", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CartItem> cartItems = new HashSet<>();

}

