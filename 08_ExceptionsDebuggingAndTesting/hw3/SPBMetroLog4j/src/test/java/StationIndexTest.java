import core.Line;
import core.Station;
import org.junit.Before;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class StationIndexTest {

    HashMap<Integer, Line> number2line;

    public Line getLine(int number) {
        return number2line.get(number);
    }

    TreeSet<Station> stations;

    TreeMap<Station, TreeSet<Station>> connections;

    public class InitLine {
        StationIndex stationIndex;

        @Before
        public void setUp() {
            InitLineTest il = new InitLineTest(); // Start BlueLine from Igor

            Line blueLine = new Line(1, "Blue");
            Station A = new Station("A", blueLine);
            Station B = new Station("B", blueLine);
            Station C = new Station("C", blueLine);
            Station D = new Station("D", blueLine);

            blueLine.addStation(A);
            blueLine.addStation(B);
            blueLine.addStation(C);
            blueLine.addStation(D);

            //il.
            stationIndex.addLine(blueLine);
            stationIndex.addStation(A);
            stationIndex.addStation(B);
            stationIndex.addStation(C);
            stationIndex.addStation(D);
        }

    }
}
