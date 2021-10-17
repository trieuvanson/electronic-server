package com.app.electronicserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Products")
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String slug;
    private String short_desc;
    private Double regular_price;
    private Double sale_price;
    private String description;
    private Boolean features;
    private Boolean best_seller;
    private String thumbnail;
    private String thumbnail2;
    private Boolean status;
    //    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "Createdate")
    private Date created_at;
    //    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "Updatedate")
    private Date update_at;

    @ManyToOne
    @JoinColumn(name = "category_id")
    ProductCategory category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<CartItem> cartItems;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<Slide> slides;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<Favorite> favorites;
}
