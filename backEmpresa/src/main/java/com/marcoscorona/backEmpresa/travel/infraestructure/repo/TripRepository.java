package com.marcoscorona.backEmpresa.travel.infraestructure.repo;

import com.marcoscorona.backEmpresa.travel.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

}
