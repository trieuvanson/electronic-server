package com.app.electronicserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
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
@Table(name = "Product_categories")
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String slug;
    private String banner;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "Createdate")
    private Date created_at;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "Updatedate")
    private Date update_at;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    Brand brand;

    @JsonIgnore
    @OneToMany(mappedBy = "category",fetch = EAGER)
    List<Product> products;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    List<New> news;
}
