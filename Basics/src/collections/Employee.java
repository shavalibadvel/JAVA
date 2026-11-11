package collections;

public class Employee implements Comparable<Employee> {
    String name;
    String dept;
    int salary;
    int age;
    long phoneNumber;
    public Employee(String name, String dept, int salary, int age, long phoneNumber) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
    @Override
    public String toString() {
        return "( "+name+", "+dept+", "+salary+", "+age+ " )";
    }
}
