package com.app.electronicserver.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "News")
public class New implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Product_categorie product_categorie;
    private Boolean status;
    private Date created_at;
    private Date updated_at;
}
