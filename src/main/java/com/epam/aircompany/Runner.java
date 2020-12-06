package com.epam.aircompany;

import com.epam.aircompany.repository.YamlPlainRepository;
import java.io.IOException;

public class Runner {

    public static void main(String[] args) throws IOException {
        Airport airport = new Airport(new YamlPlainRepository().getAll("plains.yaml"));
        Airport militaryAirport = new Airport(airport.getMilitaryPlanes());
        Airport passengerAirport = new Airport(airport.getPassengerPlane());

        System.out.println("Military airport sorted by max distance: " + militaryAirport
                .sortByMaxDistance()
                .toString());
        System.out.println("Passenger airport sorted by max speed: " + passengerAirport
                .sortByMaxSpeed()
                .toString());
        System.out.println("Plane with max passenger capacity: " + passengerAirport.getPassengerPlaneWithMaxPassengersCapacity());
    }
}
