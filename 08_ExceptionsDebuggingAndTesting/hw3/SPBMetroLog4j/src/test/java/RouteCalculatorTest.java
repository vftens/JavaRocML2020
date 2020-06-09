//package src.main.java;

import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Metro scheme that used in tests:
 * <pre>{@code
 *
 *       (Line 1)
 *      Station A - "Гостиный двор"
 *          ↓
 *     "Маяковская" Station B → "Площадь Восстания" Station E → Station G → Station H (Line 2)
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

public class RouteCalculatorTest extends TestCase {
    Line[] line;
    Station[][] station;

    StationIndex testStationIndex;
    RouteCalculator testCalculator;
    List<Station> testRoute;

    private List<Station> route;
    private Station from;
    private Station to;

    //private Station lineOne;
    //private Station lineTwo;
    private Station stationA;
    private Station stationB;
    //private Station stationC;
    private Station Station3;
    Station A, B, C, D, E, K, F, G, X, Y, Z;
    private static StationIndex stationIndex; // = null;
    private RouteCalculator routeCalculator; // = new RouteCalculator(stationIndex);;

    @Override
    protected void setUp() throws Exception {
        line = new Line[3];
        station = new Station[3][3]; // [N линии] [N станции на этой линии]

        testStationIndex = new StationIndex();
        testCalculator = new RouteCalculator(testStationIndex);
        testRoute = new ArrayList<>();

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
        testStationIndex.addConnection(new ArrayList<>(Arrays.asList(station[0][1], station[1][0])));
        testStationIndex.addConnection(new ArrayList<>(Arrays.asList(station[1][2], station[2][1])));

        InitLineTest il = new InitLineTest(); // Start BlueLine from Igor

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
        stationA = from;
        stationB = to;

        //StationIndex stationIndex = new StationIndex();
        /*
        for (Station station : Arrays.asList(A, B, C, X, Y, Z)) {
            stationIndex.addStation(station);
        }

         */

        for (Line line : Arrays.asList(lineA, lineX)) {
            stationIndex.addLine(line);
        }


        //route = routeCalculator.getShortestRoute(from, to);
        /*
        List<Station> myto = null;
        myto.add(to);
        myto.add(from);
        stationIndex.addConnection((List<Station>) myto);
        stationIndex.addStation(from); //lineOne);
        stationIndex.addStation(to);
        
         */
        super.setUp();
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

    /*
    @Test
    public void testgetShortestRoute() {
        ArrayList<Station> actual = new ArrayList<>();
        actual.add(stationA);
        actual.add(stationB);
        routeCalculator = new RouteCalculator(stationIndex);
        route = routeCalculator.getShortestRoute(stationA, stationB);
        double actual1 = routeCalculator.calculateDuration(route);
        double expected = 2.5;
        assertEquals(expected, actual1);
    }

     */

    public void testgetRouteWithOneConnection() {

    }

    public void testRouteCalculator() //StationIndex stationIndex)
    {
        StationIndex stationIndex1 = null;
        RouteCalculator ins = new RouteCalculator(stationIndex1);
        routeCalculator = new RouteCalculator(stationIndex);
        System.out.println(ins);
    }

    // тест метода расчета времени поездки
    public void testCalculateDurationMy() {

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

        assertEquals(expected, actual);
    }

    // тест метода построения маршрута - по времени поездки - маршрут без переходов
    public void testTimeOfRouteOnTheLine() throws NullPointerException {

        List<Station> testRoute = testCalculator.getShortestRoute(
                testStationIndex.getStation("Station 1 on line 1"),
                testStationIndex.getStation("Station 3 on line 1"));

        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 2 * 2.5; // 2 прогона

        assertEquals(expected, actual);
    }

    // тест метода построения маршрута - по времени поездки - маршрут  с 1 переходом
    public void testTimeOfRouteWithOneConnections() throws NullPointerException {

        List<Station> testRoute = testCalculator.getShortestRoute(
                testStationIndex.getStation("Station 1 on line 1"),
                testStationIndex.getStation("Station 2 on line 2"));

        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 2 * 2.5 + 3.5; // 2 прогона, 1 переход

        assertEquals(expected, actual);
    } // why zero, not expected?

    // тест метода построения маршрута - по времени поездки - маршрут  с 2 переходами
    public void testTimeOfRouteWithTwoConnections() throws NullPointerException {

        List<Station> testRoute = testCalculator.getShortestRoute(
                testStationIndex.getStation("Station 1 on line 1"),
                testStationIndex.getStation("Station 2 on line 3"));

        double actual = RouteCalculator.calculateDuration(testRoute);
        double expected = 3 * 2.5 + 2 * 3.5; // 3 прогона, 2 перехода

        assertEquals(expected, actual);
    } // why zero, not expected?

    public void testGetShortestRouteShouldNoNull() throws NullPointerException {

        assertNotNull(testCalculator.getShortestRoute(
                testStationIndex.getStation("Station 1 on line 1"),
                testStationIndex.getStation("Station 3 on line 3")));
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    @Test
    public void test_calculate_duration_with_equal_stations() {
        ArrayList<Station> actual = new ArrayList<>();
        actual.add(stationA);
        actual.add(stationA);
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        List<Station> route = calculator.getShortestRoute(stationA, stationA);
        double actual1 = RouteCalculator.calculateDuration(route);
        assertEquals(0.0, actual1);
    }

    /*
    @Test
    public void test_get_shortest_route_on_one_line() {
        List<Station> expected = Arrays.asList(Z, A, E);
        //z = ;
        List<Station> actual = routeCalculator.getShortestRoute(Z, E);
        assertEquals(expected, actual);
    }

    //
    public void test_distance_to_same_station() { //...

    }

    public void test_stations_next_to_each_other_on_single_line() { //...

    }

    public void test_opposite_stations_on_single_line() { //...

    }

    public void test_opposite_stations_with_two_transfers() { //...

    }

     */

    /*
    public void test_opposite_stations_with_one_transfer() { //...
        ArrayList<Station> actual = new ArrayList<>();
        actual.add(stationA);
        actual.add(Station3);
        RouteCalculator calculator = new RouteCalculator(stationIndex);
        List<Station> route = calculator.getShortestRoute(stationA, Station3);
        double actual1 = RouteCalculator.calculateDuration(route);
        assertEquals(3.5, actual1);
    }
    */

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}


/**
 * забытая схема - а нужна ли она?
 * A - B ----- E      (line1: Z - A - E)
 * |              (line2: A - B - C - D)
 * B - C - D      (line3: C - F - G)
 * |
 * F - G
 */