package com.app.electronicserver.reports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderRevenueByMothnAndYear {
    @Id
    private Serializable month;
    private Long quantity;
    private Double total;
}
