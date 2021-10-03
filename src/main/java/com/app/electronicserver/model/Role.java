package com.app.electronicserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Roles")
public class Role implements Serializable {
    @Id
    private Integer id;
    private String name;
    private Date created_at;
    private Date updated_at;
    @JsonIgnore
    @OneToMany(mappedBy = "role")
    List<Authoritie> authorities;
}
