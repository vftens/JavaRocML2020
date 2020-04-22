package com.fesva;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Flight.Type;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static com.fesva.DateUtils.asLocalDateTime;

public class Main {
    private static final int HOURS = 2;

    public static void main(String[] args) {
        // write your code here
        Airport airport = Airport.getInstance();

        List<Terminal> allTerminals;
        allTerminals = airport.getTerminals();
        List<Flight> allFlights;

        System.out.println("Classical Programming:");
        LocalDateTime lnow = LocalDateTime.now();

        for (Terminal terminal : allTerminals) {
            allFlights = terminal.getFlights();

            LocalDateTime _2HoursAfter = lnow.plusHours(HOURS);
            boolean before = lnow.isBefore(_2HoursAfter); // true
            for (Flight flight : allFlights) {
                Date mytim = flight.getDate();
                boolean before1 = lnow.isBefore(asLocalDateTime(mytim));

                boolean after = _2HoursAfter.isAfter(asLocalDateTime(mytim)); // false

                String typ = String.valueOf(flight.getType());
                boolean departureFlag = typ.equals(Type.DEPARTURE.toString());

                assert before;
                if (before1 && after && departureFlag) {
                    System.out.print(flight.getDate());
                    System.out.println(" " + flight.getAircraft().getModel());
                }
            }
        }

        System.out.println("Via allTerminals future flatMap:");

        Stream<Flight> arrivalList = allTerminals.stream()
                .flatMap(terminal -> terminal.getFlights().stream());

        arrivalList.forEach(flight -> {
            LocalDateTime _2HoursAfter = lnow.plusHours(HOURS);

            Date mytim = flight.getDate();
            boolean before1 = lnow.isBefore(asLocalDateTime(mytim));

            boolean after = _2HoursAfter.isAfter(asLocalDateTime(mytim)); // false

            String typ = String.valueOf(flight.getType());
            boolean departureFlag = typ.equals(Type.DEPARTURE.toString());

            if (before1 && after && departureFlag) {
                System.out.print(flight.getDate());
                System.out.println(" " + flight.getAircraft().getModel());
            }
        });
    }
}
