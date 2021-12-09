package com.app.electronicserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "Discounts")
@NoArgsConstructor
@AllArgsConstructor
public class Discount implements Serializable {
    @Id
    private String id;
    private Double discount;
    private Integer total;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "Created_at")
    private Date created_at;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "Expired_at")
    private Date expired_at;
    private Boolean discount_status;
}
