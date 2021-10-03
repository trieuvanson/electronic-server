package com.app.electronicserver.model;

<<<<<<< Updated upstream
public class User {
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Users")
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
    private Date birthday;
    private Boolean status;
    private Date created_at;
    private Date updated_at;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Order> orders;
>>>>>>> Stashed changes
}
