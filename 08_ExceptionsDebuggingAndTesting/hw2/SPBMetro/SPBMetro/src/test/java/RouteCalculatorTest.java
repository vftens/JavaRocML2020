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

/**
 * A - B ----- E      (line1: Z - A - E)
 * |              (line2: A - B - C - D)
 * B - C - D      (line3: C - F - G)
 * |
 * F - G
 */

public class RouteCalculatorTest extends TestCase {
    private List<Station> route;
    private Station from;
    private Station to;

    private Station lineOne;
    private Station lineTwo;
    private Station stationA;
    private Station stationB;
    private Station stationC;
    private Station Station3;
    Station A, B, C, D, E, K, F, G, Z;
    private static StationIndex stationIndex; // = null;
    private RouteCalculator routeCalculator; // = new RouteCalculator(stationIndex);;


    @Override
    protected void setUp() throws Exception {
        InitLineTest il = new InitLineTest(); // Start BlueLine from Igor



        route = new ArrayList<>();
        stationIndex = new StationIndex();

        routeCalculator = Main.getRouteCalculator();
        //routeCalculator = new RouteCalculator(stationIndex);

        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");
        route.add(new Station("Петровская", line1));
        route.add(new Station("Арбузная", line1));
        route.add(new Station("Морковная", line2));
        route.add(new Station("Яблочная", line2));

        from = new Station("Маяковская", line3);
        to = new Station("Гостиный двор", line3);
        Station3 = new Station("Площадь Восстания", line1);
        stationA = from;
        stationB = to;

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
    public void testblueLine(){
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

    @Test
    public void testgetShortestRoute() {
        ArrayList<Station> actual = new ArrayList<>();
        actual.add(stationA);
        actual.add(stationB);
        routeCalculator = Main.getRouteCalculator();
        route = routeCalculator.getShortestRoute(stationA, stationB);
        double actual1 = routeCalculator.calculateDuration(route);
        double expected = 2.5;
        assertEquals(expected, actual1);
    }

    public void testgetRouteWithOneConnection() {

    }

    public void testRouteCalculator() //StationIndex stationIndex)
    {
        StationIndex stationIndex1 = null;
        RouteCalculator ins = new RouteCalculator(stationIndex1);
        routeCalculator = Main.getRouteCalculator();
        System.out.println(ins);

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
        RouteCalculator calculator = Main.getRouteCalculator();
        List<Station> route = calculator.getShortestRoute(stationA, stationA);
        double actual1 = RouteCalculator.calculateDuration(route);
        assertEquals(0.0, actual1);
    }

    @Test
    public void test_get_shortest_route_on_one_line() {
        List<Station> expected = Arrays.asList(Z, A, E);
        List<Station> actual = routeCalculator.getShortestRoute(Z, E);
        assertEquals(expected, actual);
    }

    public void test_distance_to_same_station() { //...

    }

    public void test_stations_next_to_each_other_on_single_line() { //...
    }

    public void test_opposite_stations_on_single_line() { //...
    }

    public void test_opposite_stations_with_one_transfer() { //...
        ArrayList<Station> actual = new ArrayList<>();
        actual.add(stationA);
        actual.add(Station3);
        RouteCalculator calculator = Main.getRouteCalculator();
        List<Station> route = calculator.getShortestRoute(stationA, Station3);
        double actual1 = RouteCalculator.calculateDuration(route);
        assertEquals(3.5, actual1);
    }

    public void test_opposite_stations_with_two_transfers() { //...
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
