//package src.main.java;

import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    private List<Station> route;
    private Station from;
    private Station to;

    private Station lineOne;
    private Station lineTwo;
    private Station stationA;
    private Station stationB;
    private static StationIndex stationIndex; // = null;
    private  RouteCalculator routeCalculator; // = new RouteCalculator(stationIndex);;

    @Override
    protected void setUp() throws Exception {
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
        stationA = from;
        stationB = to;
        //route = routeCalculator.getShortestRoute(from, to);
        stationIndex.addStation(from); //lineOne);
        stationIndex.addStation(to);
        super.setUp();
    }

    @Test
    public void testgetShortestRoute()
    {
        ArrayList<Station> actual = new ArrayList<>();
        actual.add(stationA);
        actual.add(stationB);
        routeCalculator = Main.getRouteCalculator();
        route = routeCalculator.getShortestRoute(stationA, stationB);
        double actual1 = routeCalculator.calculateDuration(route);
        double expected = 2.5;
        assertEquals(expected, actual1);
    }

    public void testgetRouteWithOneConnection()
    {

    }

    public void testRouteCalculator() //StationIndex stationIndex)
    {
        StationIndex stationIndex1 = null;
        RouteCalculator ins = new RouteCalculator(stationIndex1);
        routeCalculator = Main.getRouteCalculator();
        System.out.println(ins);

    }

    public void testCalculateDuration(){
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

    public void test_distance_to_same_station() { //...
         }
    public void test_stations_next_to_each_other_on_single_line() { //...
         }
    public void test_opposite_stations_on_single_line() { //...
         }
    public void test_opposite_stations_with_one_transfer() { //...
         }
    public void test_pposite_stations_with_two_transfers() { //...
         }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
