package com.marcoscorona.backEmpresa.security.controller;

import com.marcoscorona.backEmpresa.user.application.UserService;
import com.marcoscorona.backEmpresa.user.application.UserServiceImpl;
import com.marcoscorona.backEmpresa.user.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserServiceImpl personService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
        User user = personService.getUser(username);
        if (user == null) {
            throw new Exception("User " + username + "doesn't exists.");
        }
        String userPassword = user.getPassword();
        if (!password.equals(userPassword))
            throw new Exception("Something went wrong.");

        String role = user.getRoles().toString();
        return new ResponseEntity<>(getJwtToken(username, role), HttpStatus.OK);
    }

    private String getJwtToken(String username, String role) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList(role);
        String token = Jwts.builder().setId("softtekJWT").setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
        return "Bearer " + token;
    }
}