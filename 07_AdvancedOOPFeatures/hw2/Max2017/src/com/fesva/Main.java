package com.fesva;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    private static String staffFile = "src/fesva/data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) {
        ArrayList<com.fesva.Employee> staff = loadStaffFromFile();

        staff.stream()
                .filter(employee -> Employee.getYear(employee.getWorkStart()) == 2017)
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);
    }

    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<com.fesva.Employee> staff = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for (String line : lines) {
                String[] fragments = line.split("\t");
                if (fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new com.fesva.Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }

    // write your code here
}

