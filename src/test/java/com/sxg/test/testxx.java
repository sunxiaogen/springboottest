package com.sxg.test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.MapUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class testxx {
    static ExecutorService executorService=new ThreadPoolExecutor(10,100,0L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));
    static AtomicInteger num=new AtomicInteger(0);

    public static void increase() {
        System.out.println("查询第几页："+num.get());
        num.incrementAndGet();
    }
    public static void main(String[] args) {
        int total =2000;
        CountDownLatch countDownLatch=new CountDownLatch(total);//计数器  一个线程等待其他线程各自执行完毕后再执行
        try {
            while (num.get() <= total) {
                executorService.execute(() -> {
                    increase();

                });
//                executorService.shutdown();

            }
        }catch (Exception e) {
        } finally {
            countDownLatch.countDown();
        }
//        try {
//            for (num.get() = 0; num.get() < total; num.get()++) {
//                executorService.execute(() -> {
//                    increase();
//                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
//
//                });
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//        }
        //阻塞当前线程，直到所有子线程都执行countDown方法才会继续执行
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
        }
        System.out.println("结束");
    }


//    private static final int THREADS_CONUT = 200;
//    public static AtomicInteger count = new AtomicInteger(0);
//
//    public static void increase() {
//        count.incrementAndGet();
//        System.out.println("第几次count"+count.get());
//    }
//
//    public static void main(String[] args) {
//        Thread[] threads = new Thread[THREADS_CONUT];
//        for (int i = 0; i < THREADS_CONUT; i++) {
//            threads[i] = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < 1000; i++) {
//                        increase();
//                    }
//                }
//            });
//            threads[i].start();
//        }
//
//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
//        System.out.println(count);
//    }



}
