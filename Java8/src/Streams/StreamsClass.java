package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsClass {
    public static void main(String[] args) {
        int[] numbers={9,1,23,45,22,42,54,75,29,26};

        long filteredData= Arrays.stream(numbers).filter(s->s%2==0).filter(s->s>30).sorted().count();
        System.out.println(filteredData);

        List<Employee> emps = Arrays.asList(
                new Employee("Alice",  "Eng",  90000, 30),
                new Employee("Bob",    "Eng",  75000, 25),
                new Employee("Carol",  "Sales",60000, 35),
                new Employee("Dave",   "Sales",55000, 40),
                new Employee("Eve",    "HR",   50000, 28),
                new Employee("Frank",  "Eng",  120000, 45)
        );
        //emps.forEach(System.out::println);

        // 1. filter + map + collect
        List<String> names=emps.stream().filter(e->e.getDept().equals("Eng")).map(Employee::getName).collect(Collectors.toList());
        names.forEach(System.out::println);
//        // 2. sorted by salary desc, top 3
        List<Employee> top3=emps.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
       System.out.println(top3);
//
//        // 3. sum / average with primitive streams
//        double total = emps.stream().mapToDouble(Employee::getSalary).sum();
//        OptionalDouble avg = emps.stream().mapToDouble(Employee::getSalary).average();
//        System.out.println(total + " avg=" + avg.orElse(0));
//
//        // 4. groupingBy department
//        Map<String, List<Employee>> byDept = emps.stream()
//                .collect(Collectors.groupingBy(Employee::getDept));
//        System.out.println(byDept);
//
//        // 5. groupingBy + counting
//        Map<String, Long> countByDept = emps.stream()
//                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
//        System.out.println(countByDept);              // {Eng=3, Sales=2, HR=1}
//
//        // 6. groupingBy + averaging
//        Map<String, Double> avgSalaryByDept = emps.stream()
//                .collect(Collectors.groupingBy(Employee::getDept,
//                        Collectors.averagingDouble(Employee::getSalary)));
//        System.out.println(avgSalaryByDept);
//
//        // 7. partitioningBy
//        Map<Boolean, List<Employee>> highEarners = emps.stream()
//                .collect(Collectors.partitioningBy(e -> e.getSalary() >= 80000));
//        System.out.println("High: " + highEarners.get(true));
//        System.out.println("Low:  " + highEarners.get(false));
//
//        // 8. joining
//        String namesCsv = emps.stream()
//                .map(Employee::getName)
//                .collect(Collectors.joining(", ", "[", "]"));
//        System.out.println(namesCsv);                 // [Alice, Bob, Carol, Dave, Eve, Frank]
//
//        // 9. toMap (watch duplicate keys!)
//        Map<String, Double> salaryByName = emps.stream()
//                .collect(Collectors.toMap(Employee::getName, Employee::getSalary));
//        System.out.println(salaryByName);
//
//        // 10. reduce
//        Optional<Integer> sumAges = emps.stream()
//                .map(Employee::getAge)
//                .reduce(Integer::sum);
//        System.out.println(sumAges.orElse(0));
//
//        // 11. flatMap — split words
//        List<String> sentences = Arrays.asList("hello world", "java streams");
//        List<String> words = sentences.stream()
//                .flatMap(s -> Arrays.stream(s.split(" ")))
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(words);                    // [hello, world, java, streams]
//
//        // 12. match / find
//        System.out.println(emps.stream().anyMatch(e -> e.getAge() > 40)); // true
//        System.out.println(emps.stream().allMatch(e -> e.getSalary() > 0)); // true
//        Optional<Employee> firstHr = emps.stream()
//                .filter(e -> e.getDept().equals("HR")).findFirst();
//        firstHr.ifPresent(e -> System.out.println("HR: " + e.getName()));
//
//        // 13. IntStream ranges
//        int sum = IntStream.rangeClosed(1, 100).sum();
//        System.out.println(sum);                      // 5050
//
//        // 14. parallel stream (use with care — only for CPU-bound, large, stateless work)
//        long evens = IntStream.rangeClosed(1, 1_000_000)
//                .parallel()
//                .filter(n -> n % 2 == 0)
//                .count();
//        System.out.println(evens);
    }
}
