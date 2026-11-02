public class SuperClass {
        public static void main1(){
            System.out.println("SuperClass.main");
        }
        public SuperClass() {
            System.out.println("SuperClass()");
        }
        public void printMethod(int a,int b) {
            System.out.println(a+"it is super class method"+b);
        }

}
class ChildClass extends SuperClass {
    public static void main1(){
        System.out.println("Child.main");
    }
    ChildClass() {
        super();
    }
    @Override
    public void printMethod(int a,int b) {

        super.printMethod(a,b);
        System.out.println("it is child class method");
    }
    public void printMethod2(int a,int b) {
        super.printMethod(a,b);
        System.out.println("it is child class method2");
    }
    public static void main(String[] args) {



    }
}
