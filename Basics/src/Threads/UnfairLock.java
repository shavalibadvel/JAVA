package Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLock {
    private final Lock unfairLock=new ReentrantLock();//fair=true// if true used fairness will be given else it will follow random

    public void accessRosource(){
        unfairLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" aquired Lock");
            Thread.sleep(1000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            System.out.println(Thread.currentThread().getName()+" released Lock");
            unfairLock.unlock();
        }
    }

    static void main() {
        UnfairLock example=new UnfairLock();
        Runnable task=new Runnable() {
            @Override
            public void run() {
                example.accessRosource();
            }
        };
        Thread t1=new Thread(task, "Thread-1");
        Thread t2=new Thread(task,"Thread-2");
        Thread t3=new Thread(task,"Thread-3");
        try {
            t1.start();
            //Thread.sleep(50);//if fair=false
            t2.start();
            //Thread.sleep(50);
            t3.start();
        }catch(Exception e){
            Thread.currentThread().interrupt();
        }

    }
}
