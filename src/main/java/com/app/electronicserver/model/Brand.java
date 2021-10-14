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
@Table(name = "Brands")
@NoArgsConstructor
@AllArgsConstructor
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String slugs;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "Createdate")
    private Date created_at;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "Updatedate")
    private Date update_at;

    @JsonIgnore
    @OneToMany(mappedBy = "brand",fetch = EAGER)
    List<ProductCategory> product_categories;

}
