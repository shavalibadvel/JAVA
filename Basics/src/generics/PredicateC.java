package generics;

import java.util.ArrayList;
import java.util.List;

public class PredicateC {
    void main(){
        List<String> list=List.of("Alice", "Bob", "Anna", "Charlie", "Amanda");
        // all names starts with
        List<String> filtered=list.stream().filter(s->s.startsWith("A")).toList();
        System.out.println(filtered);
        boolean findit=list.stream().anyMatch(s->s.length()>5);
        System.out.println(findit);
        boolean allMatched=list.stream().allMatch(s->!s.isEmpty());
        System.out.println(allMatched);
        boolean noneMatched=list.stream().noneMatch(s->s.startsWith("Z"));
        System.out.println(noneMatched);


    }
}
