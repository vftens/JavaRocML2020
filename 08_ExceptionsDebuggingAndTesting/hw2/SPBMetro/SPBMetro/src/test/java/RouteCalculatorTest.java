import core.Line;
import core.Station;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Metro scheme that used in tests:
 * <pre>{@code
 *
 *       (Line 1)
 *      Station A - "Гостиный двор"
 *          ↓
 *     "Маяковская" Station B → "Площадь Восстания" Station E (Station 3) → Station G → Station H → "Проспект Ветеранов" Station Z (Line 2)
 *          ↓
 *      Station C
 *          ↓
 *      Station D → Station J → Station K → Station Q (Line 3)
 *                                 ↓
 *                              Station L
 *                              (Line 4)
 *
 * }</pre>
 */

public class RouteCalculatorTest {
    private static final double INTER_STATION_TIME = 2.5;
    private static final double BETWEEN_STATIONS_TIME = 3.5;
    private static final double DELTA = 0.0000001;
    Line[] line;

    Station[][] station;

    StationIndex testStationIndex;
    RouteCalculator testCalculator;

    private List<Station> route;
    private Station from;
    private Station to;

    private Station stationA;
    private Station stationB;

    private Station Station3; // equal to Z

    Station A, B, C;
    Station E, Z;
    private StationIndex stationIndex;
    private RouteCalculator routeCalculator;

    @Before
    public void setUp() throws Exception {
        line = new Line[3];
        station = new Station[3][3]; // [N линии] [N станции на этой линии]

        Line lineOne;

        testStationIndex = new StationIndex();
        testCalculator = new RouteCalculator(testStationIndex);

        for (int l = 0; l < 3; l++) {

            line[l] = new Line(l + 1, "Line " + (l + 1));
            testStationIndex.addLine(line[l]); // добавление линии в индекс

            for (int s = 0; s < 3; s++) {

                station[l][s] = new Station("Station " + (s + 1) + " on line " + (l + 1), line[l]);
                line[l].addStation(station[l][s]); // привязка станции к линии
                testStationIndex.addStation(station[l][s]); // добавление станции в индекс
            }
        }
        // добавление переходов в индекс
        testStationIndex.addConnection(Arrays.asList(station[0][1], station[1][0]));
        testStationIndex.addConnection(Arrays.asList(station[1][2], station[2][1]));

        Line lineA = new Line(1, "lineA");
        Line lineX = new Line(2, "lineX");

        route = new ArrayList<>();
        stationIndex = new StationIndex();

        routeCalculator = new RouteCalculator(stationIndex);

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");
        route.add(new Station("K", line1));
        route.add(new Station("F", line1));
        route.add(new Station("G", line2));
        route.add(new Station("D", line2));

        from = new Station("Маяковская", line3);
        to = new Station("Гостиный двор", line3);
        Station3 = new Station("Площадь Восстания", line1);
        E = Station3;
        Z = new Station("Проспект Ветеранов", line1);
        stationA = to;
        stationB = from;

        for (Line line : Arrays.asList(lineA, lineX)) {
            stationIndex.addLine(line);
        }

        // added from InitLine
        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        lineOne = new Line(1, "1");

        A = new Station("A", lineOne);
        B = new Station("B", lineOne);
        C = new Station("C", lineOne);

        lineOne.addStation(A);
        lineOne.addStation(B);
        lineOne.addStation(C);

        stationIndex.addStation(A);
        stationIndex.addStation(B);
        stationIndex.addStation(C);

        stationIndex.addLine(lineOne);
    }

    @Test
    public void testredLine() {
        Line redLine = new Line(2, "Red");
        Station A = new Station("A", redLine);
        Station B = new Station("B", redLine);
        Station C = new Station("C", redLine);
        Station D = new Station("D", redLine);

        redLine.addStation(A);
        redLine.addStation(B);
        redLine.addStation(C);
        redLine.addStation(D);


        stationIndex.addLine(redLine);
        stationIndex.addStation(A);
        stationIndex.addStation(B);
        stationIndex.addStation(C);
        stationIndex.addStation(D);
    }

    @Test
    public void testRouteCalculator()
    {
        StationIndex stationIndex1 = null;
        RouteCalculator ins = new RouteCalculator(stationIndex1);
        routeCalculator = new RouteCalculator(stationIndex);
        assertNotNull(routeCalculator);
    }

    @Test
    // тест метода расчета времени поездки
    public void testCalculateDurationMy() {
        List<Station> testRoute;
        testRoute = new ArrayList<>();

        // Самый длинный маршрут с 2 пересадками
        testRoute.add(testStationIndex.getStation("Station 1 on line 1"));
        testRoute.add(testStationIndex.getStation("Station 2 on line 1"));
        testRoute.add(testStationIndex.getStation("Station 1 on line 2"));
        testRoute.add(testStationIndex.getStation("Station 2 on line 2"));
        testRoute.add(testStationIndex.getStation("Station 3 on line 2"));
        testRoute.add(testStationIndex.getStation("Station 2 on line 3"));
        testRoute.add(testStationIndex.getStation("Station 3 on line 3"));

        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 17.0;

        assertEquals(expected, actual, DELTA);
    }

    @Test
    // тест метода построения маршрута - по времени поездки - маршрут без переходов
    public void testTimeOfRouteOnTheLine() throws NullPointerException {
        List<Station> testRoute = testCalculator.getShortestRoute(
                testStationIndex.getStation("Station 1 on line 1"),
                testStationIndex.getStation("Station 3 on line 1"));
        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 2 * INTER_STATION_TIME; // 2 прогона
        assertEquals(expected, actual, DELTA);
    }

    @Test
    // тест метода построения маршрута - по времени поездки - маршрут  с 1 переходом
    public void testTimeOfRouteWithOneConnections() throws NullPointerException {
        List<Station> testRoute = testCalculator.getShortestRoute(
                testStationIndex.getStation("Station 1 on line 1"),
                testStationIndex.getStation("Station 2 on line 2"));
        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 2 * INTER_STATION_TIME + BETWEEN_STATIONS_TIME; // 2 прогона, 1 переход

        assertEquals(expected, actual, DELTA);
    }

    // тест метода построения маршрута - по времени поездки - маршрут  с 2 переходами
    public void testTimeOfRouteWithTwoConnections() throws NullPointerException {
        List<Station> testRoute = testCalculator.getShortestRoute(
                testStationIndex.getStation("Station 1 on line 1"),
                testStationIndex.getStation("Station 2 on line 3"));
        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 3 * INTER_STATION_TIME + 2 * BETWEEN_STATIONS_TIME; // 3 прогона, 2 перехода

        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testGetShortestRouteShouldNoNull() throws NullPointerException {
        assertNotNull(testCalculator.getShortestRoute(
                testStationIndex.getStation("Station 1 on line 1"),
                testStationIndex.getStation("Station 3 on line 3")));
    }

    @Test
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void test_calculate_duration_with_equal_stations() {
        ArrayList<Station> actual = new ArrayList<>();
        actual.add(stationA);
        actual.add(stationA);
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        List<Station> route = calculator.getShortestRoute(stationA, stationA);
        double actual_timing = RouteCalculator.calculateDuration(route);
        assertEquals(0.0, actual_timing, DELTA);
    }

    @Test
    public void test_get_shortest_route_on_one_line() {
        List<Station> expected = Arrays.asList(A, B, C);
        List<Station> actual = routeCalculator.getShortestRoute(A, C);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testblueLine() {
        Line blueLine = new Line(1, "Blue");
        Station A = new Station("A", blueLine);
        Station B = new Station("B", blueLine);
        Station C = new Station("C", blueLine);
        Station D = new Station("D", blueLine);

        blueLine.addStation(A);
        blueLine.addStation(B);
        blueLine.addStation(C);
        blueLine.addStation(D);

        stationIndex.addLine(blueLine);
        stationIndex.addStation(A);
        stationIndex.addStation(B);
        stationIndex.addStation(C);
        stationIndex.addStation(D);
    }
}
