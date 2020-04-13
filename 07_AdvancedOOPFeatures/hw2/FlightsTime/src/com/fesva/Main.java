package com.fesva;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Flight.Type;
import com.skillbox.airport.Terminal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import static com.fesva.DateUtils.asLocalDate;
import static com.fesva.DateUtils.asLocalDateTime;

public class Main {
    private static final int HOURS = 2;
    public static int getmyDate() {
        //(s1, s2) -> Flight.Type.valueOf("Time").compareTo(s2).getField(Time);
        return Type.DEPARTURE.ordinal();
    }

    public static void getmyFlights(List<Terminal> a) {
        //a.
    }

    public static int getTime() {
        return getmyDate(); //
        //Flight.class.getDeclaredMethods();
    }

    public static void main(String[] args) {
        // write your code here
        Airport airport = Airport.getInstance();

        List<Terminal> allTerminals;
        allTerminals = airport.getTerminals();

        List<Flight> allFlights;

        System.out.println("allTerminals future flatMap");
        //allTerminals.stream().flatMapToInt(terminal -> IntStream.range(0, 120)).forEach(System.out::println);

        //LocalTime currrentTime = new LocalTime();
        // terminal.stream().flatMap
        for (Terminal terminal : allTerminals) {
            allFlights = terminal.getFlights();
            //System.out.println(allFlights);

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
                boolean DepartureFlag;
                if (typ == "DEPARTURE") {
                    DepartureFlag = true;
                } else {
                    DepartureFlag = false;
                }
                assert before;
                if (before1 && after && todayFlag && DepartureFlag) {
                    System.out.print(flight.getDate());
                    System.out.println(" " + flight.getAircraft().getModel());
                }
            }
            //allFlights.stream().filter("DEPARTURE").forEach(x -> System.out.println(x));
        }

        //allFlights = getmyDate();

        //System.out.println("Terminals = " + allTerminals.size());
        //allAircrafts.stream().flatMapToInt(x -> IntStream.range(0, 120)).forEach(System.out::println);

        /*
        allAircrafts.stream().filter(aircraft -> Aircraft.getTime());
        //allAircrafts.stream().filter(Flight.Type.DEPARTURE.name());
        allAircrafts.sort(Comparator
                .comparing(Aircraft::toString)
                .reversed()
                .thenComparing((Aircraft t) -> {
                    return t.equals(Flight.getmyDate(t) );
                }) );

         */
        //allAircrafts.stream().sorted(Comparator.comparing(s -> s(Type.DEPARTURE.toString())))
        //      .ForEach(System.out::println);

        /*
        for (int i = 1; i < allAircrafts.size(); i++) //allAircrafts.get():
        {
            try {
                Aircraft consumer = allAircrafts.get(i);
                System.out.println(consumer.getModel());
                //System.out.println(consumer.getClass());
            } catch (Exception e) {
                System.out.println("Number of Aircrafts = " + i);
                break;
            }
        }

         */
        /*
        int i;
        for (i = 1; i<10_000;i++) //allAircrafts.get():
            {
                try {
                    Aircraft consumer = allAircrafts.get(i);
                    System.out.println(consumer.getModel());
                    }
                catch(Exception e){
                        System.out.println("Number of Aircrafts = " + i);
                        break;
                    }
            //);
            }

                     */
        //System.out.printf("Number of Aircrafts = %d \n", allAircrafts.size());
        //System.out.println(Flight.class.getDeclaredMethods());
        //getmyDate() );

    }
}
