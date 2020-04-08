package com.fesva;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.Comparator;
import java.util.List;

//import com.skillbox.airport.*;

public class Main {

    public  void main(String[] args) {
	// write your code here
        Airport airport = Airport.getInstance();
        List<Aircraft> allAircrafts;
        allAircrafts = airport.getAllAircrafts();
        allAircrafts.sort(Comparator
                .comparing(Aircraft::toString)
                .reversed()
                .thenComparing((Aircraft t) -> {
                    return t.equals(Flight.getDate(t) );
                }) );
        allAircrafts.stream().sorted(Comparator.comparing(Flight.Type))
                .ForEach();

        for (int i = 1; i<10;i++) //allAircrafts.get():
        {
            try {
                Aircraft consumer = allAircrafts.get(i);
                System.out.println(consumer.getModel());
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
        System.out.printf("Number of Aircrafts = %d", allAircrafts.size());

    }
}
