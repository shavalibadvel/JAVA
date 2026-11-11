package Threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private int balance=100;

    private final Lock lock=new ReentrantLock();
    public  void withdraw(int amount)  {
        System.out.println(Thread.currentThread().getName()+" Attempting to withdraw "+amount);
        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if(amount<=balance){

                    try{
                        System.out.println(Thread.currentThread().getName()+" Proceeding with withdrawal ... ");
                        Thread.sleep(3000);
                        balance-=amount;
                        System.out.println(Thread.currentThread().getName()+" completed withdrawal... Remaining amount is  "+balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }finally{
                        lock.unlock();
                    }

                }else{
                    System.out.println(Thread.currentThread().getName()+" Insufficient balance to withdraw");
                }
            }else{
                System.out.println(Thread.currentThread().getName()+" could not acquired the lock");
            }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }

    }
}
