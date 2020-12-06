package com.epam.aircompany.planes;

import com.epam.aircompany.jackson.PlaneDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@JsonDeserialize(using = PlaneDeserializer.class)
public abstract class Plane {
    private String model;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;
}
