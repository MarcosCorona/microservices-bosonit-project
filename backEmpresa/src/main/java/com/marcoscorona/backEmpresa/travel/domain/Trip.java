package com.marcoscorona.backEmpresa.travel.domain;

import com.marcoscorona.backEmpresa.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripId;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Time time;

    @Column(nullable = false)
    private Integer seatsAvailable;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "userId", unique = true)
    private List<User> passengers;

    @Column(nullable = false)
    private String status;

}
