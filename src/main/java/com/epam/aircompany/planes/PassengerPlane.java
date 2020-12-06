package com.epam.aircompany.planes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonDeserialize(as = PassengerPlane.class)
public class PassengerPlane extends Plane {
    private int passengersCapacity;
}