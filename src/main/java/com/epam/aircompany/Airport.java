package com.epam.aircompany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.epam.aircompany.planes.ExperimentalPlane;
import lombok.ToString;
import com.epam.aircompany.models.MilitaryType;
import com.epam.aircompany.planes.MilitaryPlane;
import com.epam.aircompany.planes.PassengerPlane;
import com.epam.aircompany.planes.Plane;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@ToString
@AllArgsConstructor
public class Airport {

    private List<? extends Plane> planes;

    public List<PassengerPlane> getPassengerPlane() {
        return this.planes.stream()
                .filter(plane -> plane instanceof PassengerPlane)
                .map(plane -> (PassengerPlane) plane)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        return this.planes.stream()
                .filter(plane -> plane instanceof MilitaryPlane)
                .map(plane -> (MilitaryPlane) plane)
                .collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        return passengerPlanes.stream()
                .max((o1, o2) -> o1.getPassengersCapacity() - o2.getPassengersCapacity())
                .orElseThrow(NoSuchElementException::new);
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getMilitaryPlainByType(MilitaryType.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getMilitaryPlainByType(MilitaryType.BOMBER);
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        return this.planes.stream()
                .filter(plane -> plane instanceof ExperimentalPlane)
                .map(plane -> (ExperimentalPlane) plane)
                .collect(Collectors.toList());
    }

    public Airport sortByMaxDistance() {
        return sort((o1, o2) -> o1.getMaxFlightDistance() - o2.getMaxFlightDistance());
    }

    public Airport sortByMaxSpeed() {
        return sort((o1, o2) -> o1.getMaxSpeed() - o2.getMaxSpeed());
    }

    public Airport sortByMaxLoadCapacity() {
        return sort((o1, o2) -> o1.getMaxLoadCapacity() - o2.getMaxLoadCapacity());
    }

    private Airport sort(Comparator<Plane> comparator) {
        this.planes = this.planes.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
        return this;
    }

    private List<MilitaryPlane> getMilitaryPlainByType(MilitaryType militaryType) {
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        return militaryPlanes.stream()
                .filter(plane -> plane.getType().equals(militaryType))
                .collect(Collectors.toList());
    }
}
