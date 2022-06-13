package com.sxg.test.多线程.JUC.PC;

/**
 * synchronized   线程间的通信 , 线程之间要协调和调度   生产者和消费者
 * 题目：现在四个线程，可以操作初始值为0的一个变量
 * 实现两个线程对该变量 + 1，两个线程对该变量 -1
 * 实现交替10次 ** 诀窍：
 * 1. 高内聚低耦合的前提下，线程操作资源类
 * 2. 判断 、干活、通知
 * 3. 多线程交互中，必须要防止多线程的虚假唤醒，也即（判断不能用if，只能用while）
 */

public class SyncNotifyTest01 {
    public static void main(String[] args) {
        SyncNotifyDemo01 syncNotifyDemo01 = new SyncNotifyDemo01();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    syncNotifyDemo01.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    syncNotifyDemo01.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    syncNotifyDemo01.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    syncNotifyDemo01.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class SyncNotifyDemo01 {
    public int num = 0;

    public synchronized void increment() throws InterruptedException {
        while (num == 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + ":" + num);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (num != 0) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + ":" + num);
        this.notifyAll();
    }
}
