package generics;

import java.util.ArrayList;
import java.util.List;

public class Variants {
    void main(){
        //Invariant example A extends B doesn't imply Box<A> extends Box<B> it means no relationship at all
        List<String> strings=new ArrayList<>();
        //List<Object> objects=strings;


        //covariant Example
        // if A extends B does imply Box<A> extends Box<B> it means there is a relationship
        Object[] objects2=new Object[2];
        objects2[0]=100;
        //String string2=(String) objects2[0];

        //Contravariant example
        //A extends B does imply Box[B] extends Box[A] it means there is reversed relationship


    }
}
