package com.app.electronicserver.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Slides")
public class Slide implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String images_url;
    private String link;
    private Integer postion;
    private Date created_at;
    private Date updated_at;
}
