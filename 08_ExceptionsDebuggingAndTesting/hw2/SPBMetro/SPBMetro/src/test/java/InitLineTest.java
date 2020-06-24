import core.Line;
import core.Station;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InitLineTest {

    RouteCalculator routeCalculator;
    StationIndex stationIndex;
    Line lineOne;
    Line lineTwo;
    Line lineThree;
    Station A, B, C, X, Y, Z, S, T, O, P;

    /**
     * X
     * |
     * A - B/Y ----- C         (line1: A - B - C)
     * |                  (line2: X - Y - Z)
     * Z/S - T - O - P    (line3: S - T - O - P)
     */
    @Before
    public void setUp() {
        stationIndex = new StationIndex();
        routeCalculator = new RouteCalculator(stationIndex);

        // TODO нужно добавить станции A,B,C в stationIndex так чтобы тест заработал


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
//       если нужны пересадки
//        stationIndex.addConnection(Arrays.asList(B, Y));
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

    @Test
    public void test_get_shortest_route_on_one_line() {
        List<Station> expected = Arrays.asList(A, B, C);
        List<Station> actual = routeCalculator.getShortestRoute(A, C);
        Assert.assertEquals(expected, actual);
    }


}
