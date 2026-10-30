public class Cat extends Animal {
    static  int x=10;
    public int y=11;
    private int z=12;
    public static void testClassMethod() {
        IO.println("The static method in Cat");

    }
    public void testInstanceMethod() {
        IO.println("The instance method in Cat");
    }
    static{
        int a=56;
        int b=67;
        System.out.println(x==10);
    }
    public Cat(){
        super("shavali",26);
    }
    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
        Cat.testClassMethod();
        myCat.testMethod();
        myCat.testMethod2();
        NestedStaticAnimal myNestedAnimal = new NestedStaticAnimal();
        myNestedAnimal.method2();
        myAnimal.printMethod();
        System.out.println(myCat.y);
    }
    public static void testStaticMethod() {
        System.out.println("suytqwrfgvhj");
    }
    public class NestedAnimal{
        void method1(){
            System.out.println(z);
        }
    }
    static class NestedStaticAnimal{
        void method2(){
            //System.out.println(y);
        }
    }
}
