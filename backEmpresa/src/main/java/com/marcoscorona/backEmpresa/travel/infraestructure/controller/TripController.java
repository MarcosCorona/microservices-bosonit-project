package com.marcoscorona.backEmpresa.travel.infraestructure.controller;

import com.marcoscorona.backEmpresa.travel.application.TripService;
import com.marcoscorona.backEmpresa.travel.domain.Trip;
import com.marcoscorona.backEmpresa.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDate;
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

    @PostMapping("/addPassenger/{userId}/{tripId}")
    public Trip addPassenger(@PathVariable("userId") Long newPassenger, @PathVariable("tripId") Long tripId){
        return tripService.addUserToTrip(newPassenger, tripId);
    }
    @GetMapping("/find/{tripId}")
    public Optional<Trip> getTrip(@PathVariable("tripId") Long tripId){
        return tripService.getTripById(tripId);
    }

    @GetMapping("/passenger/count/{tripId}")
    public int countOfPassengers(@PathVariable("tripId") Long tripId){
       return tripService.countOfPassengers(tripId);
    }

    @GetMapping("/disponible/{destination}")
    public List<Trip> listOfAvailableTrips(@PathVariable String destination,
                                           @RequestParam(value = "date")@DateTimeFormat(pattern="dd/MM/yyyy") LocalDate date,
                                           @RequestParam(value = "time") Time time){
        return tripService.checkTripAvailable(destination,date,time);
    }

}
