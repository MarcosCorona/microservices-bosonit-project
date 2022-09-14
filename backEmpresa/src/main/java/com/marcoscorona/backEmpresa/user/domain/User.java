package com.marcoscorona.backEmpresa.user.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

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


    public User(Optional<User> user) {
        if(user.isPresent()){
            setUserId(user.get().getUserId());
            setName(user.get().getName());
            setAge(user.get().getAge());
            setEmail(user.get().getEmail());
        }

    }
}
