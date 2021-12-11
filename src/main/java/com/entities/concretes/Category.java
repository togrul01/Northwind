package com.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Category {
    @Id
    @Column(name = "category_id",nullable = false)
    private int categoryId;

    @Column(name = "category_name",nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
