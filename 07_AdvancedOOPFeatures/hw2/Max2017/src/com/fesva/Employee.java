package com.fesva;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Employee
{
    private String name;
    private Integer salary;

    public Date getWorkStart() {
        return workStart;
    }

    public static int getYear(Date s) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(s);
        return calendar.get(Calendar.YEAR);
    }

    public static int getmyYear(Employee e) {
        return getYear(e.workStart);
    }

    private Date workStart;

    public Employee(String name, Integer salary, Date workStart)
    {
        this.name = name;
        this.salary = salary;
        this.workStart = workStart;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public String toString()
    {
        return String.format( "%-30s | %10d | %s",
                name,
                salary,
                (new SimpleDateFormat("dd.MM.yyyy")).format(workStart)
        );
    }
}
