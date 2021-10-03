package com.app.electronicserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Product_categories")
public class Product_categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String slug;
    private String banner;
    @ManyToOne
    @JoinColumn(name = "brand id")
    Brand brand;
    private Date created_at;
    private Date update_at;
    @JsonIgnore
    @OneToMany(mappedBy = "product_categorie")
    List<Product> products;
}
