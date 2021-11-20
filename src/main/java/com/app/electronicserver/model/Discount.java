package com.app.electronicserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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
}
