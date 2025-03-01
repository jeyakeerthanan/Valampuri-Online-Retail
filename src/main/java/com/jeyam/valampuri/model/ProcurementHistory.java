package com.jeyam.valampuri.model;

import com.jeyam.valampuri.config.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity
@Table(name = "procurement_histories")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true, exclude = "productSku")
public class ProcurementHistory extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_sku_id", nullable = false)
    private ProductSku productSku;

    @Column(nullable = false)
    private Integer quantityProcured;

    @Column(nullable = false)
    private Date procurementDate;

    private String procurementSource;

    private String description;

}

