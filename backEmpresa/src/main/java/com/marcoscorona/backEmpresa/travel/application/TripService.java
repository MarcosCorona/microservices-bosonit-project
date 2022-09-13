package com.marcoscorona.backEmpresa.travel.application;

import com.marcoscorona.backEmpresa.travel.domain.Trip;
import com.marcoscorona.backEmpresa.travel.exception.TripException;
import com.marcoscorona.backEmpresa.travel.infraestructure.repo.TripRepository;
import com.marcoscorona.backEmpresa.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    TripRepository tripRepository;

    public List<Trip> getTrips(){
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripById(Long tripId){
        return tripRepository.findById(tripId);
    }

    public Trip addTrip(Trip newTrip){
        return tripRepository.save(newTrip);
    }

    public Trip addUserToTrip(User user, Long tripId){
        Trip tripFetched = tripRepository.findById(tripId).orElseThrow(() -> new TripException("Trip by id " + tripId + " doesn't exists."));
        if(tripFetched.getPassengers().size() <=40){
            tripFetched.getPassengers().add(user);
        }else{
            throw new TripException("Can't fit more passengers");
        }
        return tripRepository.save(tripFetched);
    }

    public void deleteTrip(Long travelId){
        tripRepository.deleteById(travelId);
    }

    public Trip updateTrip(Trip tripUpdated){
        return tripRepository.save(tripUpdated);
    }
}
