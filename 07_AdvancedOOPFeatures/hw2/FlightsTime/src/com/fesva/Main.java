package com.fesva;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Flight.Type;
import com.skillbox.airport.Terminal;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static int getmyDate() { //Flight flight) {
        //(s1, s2) -> Flight.Type.valueOf("Time").compareTo(s2).getField(Time);
        return Type.DEPARTURE.ordinal();
    }

    public static int getTime() {
        return getmyDate(); //
        //Flight.class.getDeclaredMethods();
    }

    public static void main(String[] args) {
        // write your code here
        Airport airport = Airport.getInstance();
        List<Aircraft> allAircrafts;
        allAircrafts = airport.getAllAircrafts();
        List<Terminal> allTerminals;
        allTerminals = airport.getTerminals();

        String allFlights;
        //allFlights = getmyDate();

        System.out.println("Terminals = " + allTerminals.size());

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
        System.out.printf("Number of Aircrafts = %d \n", allAircrafts.size());
        System.out.println(Flight.class.getDeclaredMethods());
        //getmyDate() );

    }
}
