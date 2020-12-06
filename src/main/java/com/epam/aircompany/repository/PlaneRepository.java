package com.epam.aircompany.repository;

import com.epam.aircompany.planes.Plane;
import java.util.List;

public interface PlaneRepository {

    <T extends Plane> T getOne(String query);

    <T extends Plane> List<T> getAll(String query);

}
