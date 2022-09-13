package com.marcoscorona.backEmpresa.user.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.EAGER;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String name;
    private String lastname;
    private int age;
    private String email;
    private String telephone;
    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "roleId", unique = true)
    private Collection<Role> roles = new ArrayList<>();
    private String username;
    private String password;



}
