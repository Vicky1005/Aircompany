package com.epam.aircompany.jackson;

import com.epam.aircompany.planes.ExperimentalPlane;
import com.epam.aircompany.planes.MilitaryPlane;
import com.epam.aircompany.planes.PassengerPlane;
import com.epam.aircompany.planes.Plane;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;

public class PlaneDeserializer extends JsonDeserializer<Plane> {

    @Override
    public Plane deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        ObjectNode root = mapper.readTree(jsonParser);
        Class<? extends Plane> instanceClass;
        if (root.has("passengersCapacity")) {
            instanceClass = PassengerPlane.class;
        } else if (root.has("classificationLevel")) {
            instanceClass = ExperimentalPlane.class;
        } else {
            instanceClass = MilitaryPlane.class;
        }
        return mapper.readValue(root.traverse(), instanceClass);
    }
}