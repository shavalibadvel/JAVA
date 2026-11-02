package Threads;

public class Test {
    static void main() {
//        Branch branch = new Branch();
//        Thread thread1 = new Thread(branch);
//        thread1.start();
//        for(int i = 0; i < 10000; i++){
//            System.out.println(Thread.currentThread().getName());
//        }
        System.out.println(main2());
//

    }
    static int main2() {
        try{
            int a=100/0;
            return 100;
        }
        catch(Exception e){
            System.out.println("error");
            return -1;
        }finally{
            return 0;
        }
    }
}
