public class Animal {
    String name;
    int age;
    public Animal(String name,int age){
        this.name=name;
        this.age=age;
    }
    public Animal(){

    }
    public static void testClassMethod() {
        IO.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        IO.println("The instance method in Animal");
    }
    void testMethod() {
        System.out.println("test method in Animal");
    }
    protected void testMethod2(){
        System.out.println("test protected method in Animal");
    }
    void printMethod(){
        System.out.println("name"+this.name+" age"+this.age);
    }
}
