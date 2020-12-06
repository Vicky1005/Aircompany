package com.epam.aircompany.repository;

import com.epam.aircompany.planes.Plane;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.SneakyThrows;
import java.io.InputStream;
import java.util.List;

public class YamlPlainRepository implements PlaneRepository {

    @SneakyThrows
    public <T extends Plane> T getOne(String query) {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(query);
        ObjectMapper omPattern = new ObjectMapper(new YAMLFactory());
        return omPattern.readValue(stream, new TypeReference<T>() {
        });
    }

    @SneakyThrows
    public <T extends Plane> List<T> getAll(String query) {
        InputStream stream = getClass().getClassLoader().getResourceAsStream(query);
        ObjectMapper omPattern = new ObjectMapper(new YAMLFactory());
        return omPattern.readValue(stream, new TypeReference<List<T>>() {
        });
    }
}

