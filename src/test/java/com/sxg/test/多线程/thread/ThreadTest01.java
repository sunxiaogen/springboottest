package com.sxg.test.多线程.thread;

public class ThreadTest01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("启动多线程执行："+i);
        }
    }

    public static void main(String[] args) {
        ThreadTest01 thread01 = new ThreadTest01();
        thread01.start();
        for (int i = 0; i < 500; i++) {
            System.out.println("正常执行："+i);

        }
    }
}
