package com.sxg.test;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test01  implements Runnable{
    static Lock lock = new ReentrantLock();//这是一种重入互斥锁
    private static int count=0;

    public void inc(){
        try {
            lock.lock();//加锁操作  t1线程获得了这把锁
            Thread.sleep(1);
            decr();
            count++; //并不是原子操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//释放锁
        }

    }
    public static void decr(){
        lock.lock();  //锁竞争  t1线程继续抢占锁，记录锁的次数
        lock.unlock();
    }

    public static void main(String[] args) {
        for (int i =0;i<1000;i++){
            new Thread(new Test01()).start();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);

    }

    @Override
    public void run() {
        Test01 test = new Test01();
        test.inc();
    }


}
