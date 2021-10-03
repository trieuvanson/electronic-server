package com.app.electronicserver.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Authorities")
public class Authoritie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "username")
    User user;
    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;
}
