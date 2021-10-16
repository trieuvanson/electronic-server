package com.app.electronicserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Favorites")
@NoArgsConstructor
@AllArgsConstructor
public class Favorite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "Createdate")
    private Date created_at;

    @ManyToOne
    @JoinColumn(name = "productid")
    Product product;

    @ManyToOne
    @JoinColumn(name = "username")
    User user;
}
