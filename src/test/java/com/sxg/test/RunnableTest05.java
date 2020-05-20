package com.sxg.test;


import java.util.concurrent.CountDownLatch;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 常见的协作配合


 上面那些场景，其实都是对一个线程的操作，下面来看多线程间的一些配合。

 事件一，考试

 假设今天考试，20个学生，1个监考老师。规定学生可以提前交卷，即把卷子留下，直接走人就行了。

 但老师必须等到所有的学生都走后，才可以收卷子，然后装订打包。

 如果把学生和老师都看作线程，就是1个线程和20个线程的配合问题，即等20个线程都结束了，这1个线程才开始。

 比如20个线程分别在计算数据，等它们都结束后得到20个中间结果，最后这1个线程再进行后续汇总、处理等。

 解说：每完成一个线程，计数器减1，当减到0时，被阻塞的线程自动执行。
 */

public class RunnableTest05 {

    static final int COUNT = 20;

    public static void main(String[] args) throws Exception {
        new Thread(new Teacher(cdl)).start();
        Thread.sleep(1000);
        for (int i = 0; i < COUNT; i++) {
            new Thread(new Student(i, cdl)).start();
        }
        synchronized (Teacher.class) {
            Teacher.class.wait();
        }
    }

    static CountDownLatch cdl = new CountDownLatch(COUNT);

    static class Teacher implements Runnable {

        CountDownLatch cdl;

        Teacher(CountDownLatch cdl) {
            this.cdl = cdl;
        }

        @Override
        public void run() {
            println("老师发卷子。。。");
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            println("老师收卷子。。。");
        }

    }

    static class Student implements Runnable {

        CountDownLatch cdl;
        int num;

        Student(int num, CountDownLatch cdl) {
            this.num = num;
            this.cdl = cdl;
        }

        @Override
        public void run() {
            println("学生(%d)写卷子。。。"+num);
//            doingLongTime();
            println("学生(%d)交卷子。。。"+ num);
            cdl.countDown();
        }

    }



}
