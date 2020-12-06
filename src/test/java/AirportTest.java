import com.epam.aircompany.Airport;
import com.epam.aircompany.repository.YamlPlainRepository;
import com.epam.aircompany.planes.Plane;
import lombok.extern.slf4j.Slf4j;
import com.epam.aircompany.models.ClassificationLevel;
import com.epam.aircompany.models.MilitaryType;
import org.junit.jupiter.api.*;
import com.epam.aircompany.planes.ExperimentalPlane;
import com.epam.aircompany.planes.MilitaryPlane;
import com.epam.aircompany.planes.PassengerPlane;
import java.util.List;

@Slf4j
public class AirportTest {

    @BeforeEach
    public void log(TestInfo testInfo) {
        log.info(String.format("test started: %s ", testInfo.getDisplayName()));
    }

    @Test
    @DisplayName("Has Transport Military Planes")
    public void hasTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new Airport(new YamlPlainRepository().getAll("plains.yaml"))
                .getTransportMilitaryPlanes();
        Assertions.assertTrue(transportMilitaryPlanes.stream()
                .anyMatch(militaryPlane -> militaryPlane.getType().equals(MilitaryType.TRANSPORT)));
    }

    @Test
    @DisplayName("Verify Passenger Plane With Max Capacity")
    public void verifyPlaneWithMaxCapacity() {
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = new Airport(new YamlPlainRepository().getAll("plains.yaml"))
                .getPassengerPlaneWithMaxPassengersCapacity();
        Assertions.assertEquals(expectedPlaneWithMaxPassengersCapacity, new YamlPlainRepository()
                .getOne("plainWithMaxPassengerCapacity.yaml"));
    }

    @Test
    @DisplayName("Verify Planes Sorted By Max Load Capacity")
    public void verifyPlanesSortedByMaxLoadCapacity() {
        Airport airport = new Airport(new YamlPlainRepository().getAll("plains.yaml"));
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity().getPlanes();
        List<Plane> expectedPlanesSortedByMaxLoadCapacity = new YamlPlainRepository().getAll("plainsByMaxLoadCapacity.yaml");
        Assertions.assertEquals(expectedPlanesSortedByMaxLoadCapacity, planesSortedByMaxLoadCapacity);
    }

    @Test
    @DisplayName("Has One Bomber In Military Planes")
    public void hasOneBomberInMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new Airport(new YamlPlainRepository().getAll("plains.yaml"))
                .getBomberMilitaryPlanes();
        Assertions.assertTrue(bomberMilitaryPlanes.stream()
                .anyMatch(militaryPlane -> militaryPlane.getType().equals(MilitaryType.BOMBER)));
    }

    @Test
    @DisplayName("Has Unclassified Experimental Planes")
    public void hasUnclassifiedExperimentalPlanes() {
        List<ExperimentalPlane> ExperimentalPlanes = new Airport(new YamlPlainRepository().getAll("plains.yaml"))
                .getExperimentalPlanes();
        Assertions.assertFalse(ExperimentalPlanes.stream()
                .anyMatch(militaryPlane -> militaryPlane.getClassificationLevel().equals(ClassificationLevel.UNCLASSIFIED)));
    }
}
