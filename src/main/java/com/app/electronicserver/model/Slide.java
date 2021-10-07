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
@Table(name = "Slides")
@NoArgsConstructor
@AllArgsConstructor
public class Slide implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String images_url;
    private String link;
    private Integer postion;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "Createdate")
    private Date created_at;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Column(name = "Updatedate")
    private Date update_at;
}
