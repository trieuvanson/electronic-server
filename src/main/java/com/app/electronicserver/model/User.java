package com.app.electronicserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Id
    private String username;
    private String password;
    private String avatar;
    private String fullname;
    private String phone;
    private String email;
    private String address;
    private Boolean gender;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private Boolean status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "Createdate")
    private Date created_at;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "Updatedate")
    private Date update_at;

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Order> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<CartItem> cartItems;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Address> addresses;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Favorite> favorites;
}
