package com.jeyam.valampuri.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "wishlist_items")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class WishlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wishlist_id", nullable = false)
    private Wishlist wishlist;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_sku_id", nullable = false)
    private Set<ProductSku> productSkus;

    // Additional fields as necessary
}

