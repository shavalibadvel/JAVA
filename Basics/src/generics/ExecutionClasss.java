package generics;

import java.util.ArrayList;
import java.util.List;

public class ExecutionClasss {
    void main(){
        System.out.println("Hello");
        Mine<Integer,String,Character> mine=new Mine<>();
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(mine.printFirstElementValue(list));
        Character c=new Character('x');

        System.out.println(mine.convertToString(1));
    }
}
