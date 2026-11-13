package Streams;

import java.util.*;
import java.util.stream.*;

public class Employee {
    private final String name;
    private final String dept;
    private final double salary;
    private final int age;

    public Employee(String name, String dept, double salary, int age) {
        this.name = name; this.dept = dept; this.salary = salary; this.age = age;
    }
    public String getName()  { return name; }
    public String getDept()  { return dept; }
    public double getSalary(){ return salary; }
    public int getAge()      { return age; }
    @Override public String toString() {
        return name + "(" + dept + "," + salary + ")";
    }
}