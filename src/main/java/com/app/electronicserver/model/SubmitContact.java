package com.app.electronicserver.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "SubmitContacts")
public class SubmitContact implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String content;
    private Boolean status;
    private Date created_at;
    private Date updated_at;
}
