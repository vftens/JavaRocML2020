package com.fesva;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main
{
    private static String staffFile = "src/fesva/data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args)
    {
        ArrayList<com.fesva.Employee> staff = loadStaffFromFile();

        // top payment first

        // by standard comparator
//        staff.sort(Comparator
//                .comparingInt(Employee::getSalary)
//                .reversed()
//                .thenComparing(Employee::getName)
//        );

        // by lambda
        staff.sort((e1,e2) -> {
            int diff = e2.getSalary() - e1.getSalary();
            if (diff == 0) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return diff;
            }
        });

        for (com.fesva.Employee e :
                staff) {
            System.out.println(e);
        }
    }

    private static ArrayList<com.fesva.Employee> loadStaffFromFile()
    {
        ArrayList<com.fesva.Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new com.fesva.Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}