package com.entities.concretes;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "product_id",nullable = false)
    private int id;

    @Column(name = "product_name",nullable = false)
    private String productName;

    @Column(name = "unit_price",nullable = false)
    private double unitPrice;

    @Column(name = "units_in_stock",nullable = false)
    private short unitsInStock;

    @Column(name = "quantity_per_unit",nullable = false)
    private String quantityPerUnit;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;


}
