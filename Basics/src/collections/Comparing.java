package collections;

import java.util.*;

public class Comparing {
    static void main() {
        List<String> list = new ArrayList(List.of("hello1", "wordl", "this","next","allow","node"));
        Comparator<String> com=(a,b)->b.compareTo(a);
        list.sort(com);
        System.out.println(list);


    }
}
