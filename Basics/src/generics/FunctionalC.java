package generics;


import java.util.ArrayList;
import java.util.List;

public class FunctionalC {
    void main(){
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // 1. map — String → Integer (length)
        List<Integer> lengths = names.stream()
                .map(s -> s.length())                  // lambda IS a Function<String, Integer>
                .toList();
        System.out.println(lengths);                   // [5, 3, 7]

        // 2. map — String → String (uppercase)
        List<String> upper = names.stream()
                .map(String::toUpperCase)              // method reference = Function<String, String>
                .toList();
        System.out.println(upper);                     // [ALICE, BOB, CHARLIE]

        // 3. mapToInt — primitive specialization
        int total = names.stream()
                .mapToInt(String::length)              // ToIntFunction<String>
                .sum();
        System.out.println(total);
    }

    public static void main(String[] args) {
        System.out.println("hellow world");
        FunctionalC fc = new FunctionalC();
        fc.main();
    }
}
