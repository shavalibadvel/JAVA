import java.util.Arrays;

public class InheritenceClass {
    static String name1="shavali";
     String age="10";
    public void animal() {
        IO.println(String.format("Hello, animal!"));
    }
}
class Dog extends InheritenceClass implements interface1{
//    @Override
//    public void animal() {
//        IO.println(String.format("Hello, animal!"));
//    }
    void main() {
        int[] arr={1,2,3,4};
//        int[] arr2={...arr};
        int[] arr2=arr.clone();
        int cho='c';
        System.out.println((char)140);

        arr2[2]=6;
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr));
        int[] arr3=arr;
        arr3[0]=5;

        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr));

//        Dog d=new Dog();
//        interface1 i1=new Dog();
//        d.animal();
//        d.age="32";
//        d.name1="iuysdfghjk";
//        System.out.println((10==10));
//        Integer a=10;
//        Integer b=10;
//        System.out.println(a.equals(b));
//
//        System.out.println(d.age);
//        System.out.println(InheritenceClass.name1);
//        System.out.println(i1.main2());
    }


    public void main1() {
        System.out.println("main1");
    }


    public int main2() {
        return 2;
    }


    public int main3() {
        return 3;
    }


    public int main4() {
        return 4;
    }
}
