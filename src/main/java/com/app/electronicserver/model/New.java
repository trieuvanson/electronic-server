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
}
