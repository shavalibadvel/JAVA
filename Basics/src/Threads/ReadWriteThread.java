package Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteThread {
    private int counter=0;
    private final ReentrantReadWriteLock lock= new ReentrantReadWriteLock();
    private final Lock writeLock=lock.writeLock();
    private final Lock readLock=lock.readLock();

    public void increament(){
        writeLock.lock();
        try{
            counter++;
        }finally{
            writeLock.unlock();
        }
    }
    public int getcount(   ){
        readLock.lock();
        try{
            return counter;

        }finally{
            readLock.unlock();

        }

    }

    static void main() throws InterruptedException {
        ReadWriteThread counter = new ReadWriteThread();
        Runnable readTask = new Runnable() {
            public void run() {
               for(int i=0;i<10;i++){
                   System.out.println(Thread.currentThread().getName()+" is "+counter.getcount());
               }
            }
        };
        Runnable writeTask = new Runnable() {
            public void run() {
                for(int i=0;i<10;i++){
                    counter.increament();
                    System.out.println(Thread.currentThread().getName()+" is incremented");
                }
            }
        };
        Thread writeThread = new Thread(writeTask,"write thread");
        Thread readThread1= new Thread(readTask,"read thread1");
        Thread readThread2 = new Thread(readTask,"read thread3");

        writeThread.start();
        readThread1.start();
        readThread2.start();

        writeThread.join();
        readThread1.join();
        readThread2.join();
        System.out.println("final count : "+counter.getcount());


    }
}
