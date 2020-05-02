//package src.main.java;

import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    Station from;
    Station to;

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        Line line3 = new Line(3, "Третья");
        route.add(new Station("Петровская", line1));
        route.add(new Station("Арбузная", line1));
        route.add(new Station("Морковная", line2));
        route.add(new Station("Яблочная", line2));

        from = new Station("Маяковская", line3);
        to = new Station("Гостиный двор", line3);
        super.setUp();
    }

    public void testgetShortestRoute()
    {
        route = RouteCalculator.getShortestRoute(from,  to);
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 2.5;
        assertEquals(expected, actual);
    }

    public void testgetRouteWithOneConnection()
    {

    }

    public void testRouteCalculator() //StationIndex stationIndex)
    {
        StationIndex stationIndex1 = null;
        RouteCalculator ins = new RouteCalculator(stationIndex1);
        System.out.println(ins);

    }

    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
