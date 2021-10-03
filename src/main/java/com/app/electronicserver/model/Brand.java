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
@Table(name = "Brands")
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String slugs;
    private Date created_at;
    private Date update_at;
    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    List<Product_categorie> product_categories;
}
