package com.sxg.test.多线程.runnable;

public class RunnableTest11 {


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 600; i++) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 600; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
