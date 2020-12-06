package com.epam.aircompany.planes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import com.epam.aircompany.models.ClassificationLevel;
import com.epam.aircompany.models.ExperimentalType;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonDeserialize(as = ExperimentalPlane.class)
public class ExperimentalPlane extends Plane {
    private ExperimentalType type;
    private ClassificationLevel classificationLevel;
}
