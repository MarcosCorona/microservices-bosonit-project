package com.marcoscorona.backEmpresa.user.application;

import com.marcoscorona.backEmpresa.user.domain.Role;
import com.marcoscorona.backEmpresa.user.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename);
    User getUser(String username);
    List<User> getUsers();

}
