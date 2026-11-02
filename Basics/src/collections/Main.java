package collections;

import java.util.*;

public class Main {
    void main(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("world");
        list.add("shavali");
        list.add("badvel");
        list.add("goodvel");
        String s=list.get(1);
        list.remove("badvel");
        Collections.sort(list);
        list.sort((a,b)->a.compareTo(b));
        System.out.println(list);
        // it is not synchronized and also it is contigous memory
        // good cache locality and takes less memory
        // grows by 50%
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("hello");
        linkedList.add("world");
        linkedList.add("shavali");
        linkedList.add("badvel");
        linkedList.add("goodvel");
        linkedList.sort((a,b)->a.compareTo(b));
        linkedList.get(3);
        // it is like node which contains element , 2 pointers for next and prev
        // scattered memory , terrible cache locality and more momory

        Vector<String> vector = new Vector<>();
        vector.add("hello");
        vector.add("world");
        vector.add("shavali");
        vector.add("badvel");
        vector.add("goodvel");
        vector.add(null);
        vector.sort((a,b)->a.compareTo(b));
        vector.get(3);
        vector.remove(3);
        // it is like Arraylist with synchronized version and
        //grows by 100%;


        Map<String, Integer> map = new Hashtable<>();
        map.put("hello", 1);
        map.put("world", 2);
        map.put("shavali", 3);
    }
}
