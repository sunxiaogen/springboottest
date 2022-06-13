package com.sxg.test;


import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolTest01 implements Runnable{
    static Lock lock = new ReentrantLock();//这是一种重入互斥锁

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public void inc(){
//        System.out.println(""+Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());

    }
    public static void decr(){
        lock.lock();  //锁竞争  t1线程继续抢占锁，记录锁的次数
        lock.unlock();
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
//        //相当于我构建了5个线程的线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        Thread t1 = new Thread(new ThreadPoolTest01());
//        executorService.submit(t1);
////        executorService.execute();

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            ThreadPoolTest01 worker = new ThreadPoolTest01();
            //执行Runnable
            executor.execute(worker);
        }
        //终止线程池
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

    @Override
    public void run() {
        ThreadPoolTest01 test = new ThreadPoolTest01();
        test.inc();
    }


}
