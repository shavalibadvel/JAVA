package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorClass {
    public static void main(String[] args) {
//        Employee e1=new Employee("shavali","Tech",250000,25,918732642);
//        Employee e2  = new Employee("rahul",    "Finance",  180000, 30, 987654321);
//        Employee e3  = new Employee("priya",    "HR",       150000, 28, 912345678);
//        Employee e4  = new Employee("amit",     "Tech",     220000, 32, 998877665);
//        Employee e5  = new Employee("sneha",    "Marketing", 170000, 27, 909090909);
//        Employee e6  = new Employee("vikram",   "Tech",     300000, 35, 934567890);
//        Employee e7  = new Employee("anita",    "Finance",  260000, 29, 945612378);
//        Employee e8  = new Employee("karthik",  "HR",       140000, 24, 956789123);
//        Employee e9  = new Employee("divya",    "Marketing", 190000, 31, 967812345);
//        Employee e10 = new Employee("suresh",   "Tech",     210000, 26, 978923456);
//        List<Employee> list=new ArrayList<>(List.of(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10));
//        Collections.sort(list);
//        System.out.println(list);
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("shavali", "Tech",      250000, 25, 918732642L),
                new Employee("shavali", "Finance",   250000, 30, 918732643L),
                new Employee("rahul",   "Tech",      180000, 28, 987654321L),
                new Employee("rahul",   "HR",        220000, 28, 987654322L),
                new Employee("priya",   "Tech",      250000, 28, 912345678L),
                new Employee("amit",    "Tech",      250000, 25, 998877665L),
                new Employee("sneha",   "Finance",   180000, 30, 909090909L),
                new Employee("vikram",  "Tech",      300000, 35, 934567890L),
                new Employee("anita",   "HR",        140000, 28, 945612378L),
                new Employee("divya",   "Marketing", 180000, 24, 967812345L)
        ));
        Comparator<Employee> comp=(a,b)->{
            int r=a.name.compareTo(b.name);
            if(r==0) {
                int x=a.salary-b.salary;
                if(x==0) {
                    return a.age-b.age;
                }else return x;
            }else return r;
        };
        employees.sort(comp);
        System.out.println(employees);

    }
}
