package com.fesva;

import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Flight.Type;
import com.skillbox.airport.Terminal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import static com.fesva.DateUtils.asLocalDate;
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

        for (Terminal terminal : allTerminals) {
            allFlights = terminal.getFlights();

            LocalTime now = LocalTime.now();
            LocalDate today = LocalDate.now();
            int day = today.getDayOfMonth();
            LocalTime _2HoursAfter = now.plusHours(HOURS);
            boolean before = now.isBefore(_2HoursAfter); // true
            for (Flight flight : allFlights) {
                Date mytim = flight.getDate();
                boolean before1 = now.isBefore(LocalTime.from(asLocalDateTime(mytim)));

                boolean todayFlag;
                if (day == asLocalDate(mytim).getDayOfMonth()) {
                    todayFlag = true;
                } else {
                    todayFlag = false;
                }
                boolean after = _2HoursAfter.isAfter(LocalTime.from(asLocalDateTime(mytim))); // false

                String typ = String.valueOf(flight.getType());
                boolean departureFlag;
                if (typ.equals(Type.DEPARTURE.toString())) { // "DEPARTURE"
                    departureFlag = true;
                } else {
                    departureFlag = false;
                }
                assert before;
                if (before1 && after && todayFlag && departureFlag) {
                    System.out.print(flight.getDate());
                    System.out.println(" " + flight.getAircraft().getModel());
                }
            }
        }

        System.out.println("Via allTerminals future flatMap:");

        Stream<Flight> arrivalList = allTerminals.stream()
                .flatMap(terminal -> terminal.getFlights().stream());

        arrivalList.forEach(flight -> {
            LocalTime now = LocalTime.now();
            LocalDate today = LocalDate.now();
            int day = today.getDayOfMonth();
            LocalTime _2HoursAfter = now.plusHours(HOURS);

            Date mytim = flight.getDate();
            boolean before1 = now.isBefore(LocalTime.from(asLocalDateTime(mytim)));

            boolean todayFlag;
            if (day == asLocalDate(mytim).getDayOfMonth()) {
                todayFlag = true;
            } else {
                todayFlag = false;
            }
            boolean after = _2HoursAfter.isAfter(LocalTime.from(asLocalDateTime(mytim))); // false

            String typ = String.valueOf(flight.getType());
            boolean departureFlag;
            if (typ.equals(Type.DEPARTURE.toString())) {
                departureFlag = true;
            } else {
                departureFlag = false;
            }
            if (before1 && after && todayFlag && departureFlag) {
                System.out.print(flight.getDate());
                System.out.println(" " + flight.getAircraft().getModel());
            }
        });
    }
}
