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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Boolean status;
    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate")
    private Date created_at;
    @Temporal(TemporalType.DATE)
    @Column(name = "Updatedate")
    private Date update_at;

    @ManyToOne
    @JoinColumn(name = "category_id")
    ProductCategory product_categorie;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;
}
