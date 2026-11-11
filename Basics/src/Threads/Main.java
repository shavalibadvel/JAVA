package Threads;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    static void main() {
        Bank bank = new Bank();
        Runnable task=new Runnable() {
            @Override
            public void run() {
                bank.withdraw(50);
            }
        };
//        Thread t1=new Thread(task,"Thread 1");
//        Thread t2=new Thread(task,"Thread 2");
//        t1.start();
//        t2.start();
        Executor executor= new Executor() {
            @Override
            public void execute(Runnable command) {

            }
        };
        executor.execute(task);


    }
}
