package com.epam.aircompany.planes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import com.epam.aircompany.models.MilitaryType;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonDeserialize(as = MilitaryPlane.class)
public class MilitaryPlane extends Plane {
    private MilitaryType type;
}
