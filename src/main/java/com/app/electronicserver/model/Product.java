package com.app.electronicserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String slug;
    private String short_desc;
    private Double regular_price;
    private Double slae_price;
    private String description;
    private Boolean features;
    private Boolean best_seller;
    private String thumbnail;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Product_categorie product_categorie;
    private boolean status;
    private Date created_at;
    private Date updated_at;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;
}
