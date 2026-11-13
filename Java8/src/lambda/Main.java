package lambda;

public class Main {
    static void main() {
        int a=10;
        int b=20;
        Dowork<Integer> something=(y,x)-> x+y;
        System.out.println(something.operation(10,20));

    }

}
@FunctionalInterface
interface  Dowork<T>{
    public  T operation(T x,T y);

}
