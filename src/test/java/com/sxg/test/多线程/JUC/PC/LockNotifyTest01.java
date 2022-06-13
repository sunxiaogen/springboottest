package com.sxg.test.多线程.JUC.PC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程间的通信 , 线程之间要协调和调度   生产者和消费者
 * 题目：现在四个线程，可以操作初始值为0的一个变量
 * 实现两个线程对该变量 + 1，两个线程对该变量 -1
 * 实现交替10次 * <p> * 诀窍：
 * 1. 高内聚低耦合的前提下，线程操作资源类
 * 2. 判断 、干活、通知
 * 3. 多线程交互中，必须要防止多线程的虚假唤醒，也即（判断不能用if，只能用while）
 */
public class LockNotifyTest01 {
    public static void main(String[] args) {
        LockNotifyDemo01 lockNotifyDemo01 = new LockNotifyDemo01();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lockNotifyDemo01.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lockNotifyDemo01.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lockNotifyDemo01.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lockNotifyDemo01.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class LockNotifyDemo01 {
    public int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public  void increment() throws InterruptedException {
        lock.lock();
        try {
            while (num ==0) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + ":" + num);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public  void decrement() throws InterruptedException{
        lock.lock();
        try {
            while (num !=0) {
              condition.await();
            }
            num --;
            System.out.println(Thread.currentThread().getName() + ":" + num);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
