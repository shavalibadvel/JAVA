package lambda;

import java.util.List;
import java.util.function.*;

public class FunctionalInterfaceClass {

    @FunctionalInterface
    static interface TriFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }
    @SuppressWarnings("checked")
    public static void main(String[] args) {


        Function<Integer, Integer> times2 = x -> x * 2;
        Function<Integer, Integer> plus3  = x -> x + 3;
        System.out.println(times2.andThen(plus3).apply(5));
        System.out.println(times2.compose(plus3).compose(plus3).apply(5));

        Predicate<String> nonEmpty   = s -> !s.isEmpty();
        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> both = nonEmpty.and(startsWithA);
        System.out.println(both.test("Alice"));
        System.out.println(both.negate().test("Alice"));

        Consumer<String> print  = s -> System.out.print(s + " ");
        Consumer<String> upper  = s -> System.out.print(s.toUpperCase()+" ");
        Consumer<String> lower  = s -> System.out.print(s.toLowerCase()+" ");

        print.andThen(lower).andThen(upper).accept("hi Junk");
        System.out.println();


        Supplier<List<String>> listFactory = () -> new java.util.ArrayList<>();
        System.out.println(listFactory.get().size());


        BiFunction<Integer, Integer, Integer> max = (a, b) -> a > b ? a : b;
        System.out.println(max.apply(7, 12));

        TriFunction<Integer, Integer, Integer, Integer> sum3 = (a, b, c) -> a + b + c;
        System.out.println(sum3.apply(1, 2, 3));

        IntPredicate even = n -> n % 2 == 0;
        System.out.println(even.test(10));
    }
}