package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolClass {
    static void main() {
        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < 30; i++) {
            executorService.execute(new Task1());
        }
        System.out.println(Thread.currentThread().getName());
        executorService.shutdown();
    }
    static class Task1 implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
