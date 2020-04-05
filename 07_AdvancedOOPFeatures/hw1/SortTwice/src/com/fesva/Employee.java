package com.fesva;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee
{
    private String name;
    private Integer salary;
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
