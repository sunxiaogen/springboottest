package com.sxg.test.多线程.runnable;

public class RunnableTest10 implements Runnable {

    int age;
    int name;

    public RunnableTest10(int age, int name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName()+"打印runable线程："+i+"age:"+age+"name"+name);
        }
    }

    public static void main(String[] args) {

        RunnableTest10 runnableTest01 = new RunnableTest10(1,2);
        RunnableTest10 runnableTest02 = new RunnableTest10(11,22);
        RunnableTest10 runnableTest03 = new RunnableTest10(111,222);
        //创建线程对象，通过线程对象来开启我们的线程，代理
        new Thread(runnableTest01,"diyi").start();
        new Thread(runnableTest02,"dier").start();
        new Thread(runnableTest03,"ds").start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程执行："+i);
        }

    }
}
