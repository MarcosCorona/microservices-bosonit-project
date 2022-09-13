package com.marcoscorona.backEmpresa.travel.infraestructure.controller;

import com.marcoscorona.backEmpresa.travel.application.TripService;
import com.marcoscorona.backEmpresa.travel.domain.Trip;
import com.marcoscorona.backEmpresa.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.LongAdder;

@RestController
@RequestMapping("/trip")
public class TripController {
    @Autowired
    TripService tripService;

    @GetMapping
    public List<Trip> getTrips(){
        return tripService.getTrips();
    }
    @PostMapping
    public Trip addTrip(@RequestBody Trip newTrip){
        return  tripService.addTrip(newTrip);
    }

    @PostMapping("/addPassenger/{tripId}")
    public Trip addPassenger(@RequestBody User newPassenger, @RequestParam Long tripId){
        return tripService.addUserToTrip(newPassenger, tripId);
    }
    @GetMapping("/find/{tripId}")
    public Optional<Trip> getTrip(@RequestParam Long tripId){
        return tripService.getTripById(tripId);
    }

}
