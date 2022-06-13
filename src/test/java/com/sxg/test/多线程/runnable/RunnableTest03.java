package com.sxg.test.多线程.runnable;


import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 场景三，插队

 “大胖，大胖，让我站到你前面，不想排队了”

 “好吧”

 要点：别人插队到你前面，必须等他完事后才轮到你。

 解说：join方法可以让某个线程插到自己前面，等它执行完，自己才会继续执行。
 */

public class RunnableTest03 {


    static void jqByJoin() {
        CRunnable cr = new CRunnable();
        Thread t = new Thread(cr);
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("终于轮到我了");
    }

    static class CRunnable implements Runnable {

        @Override
        public void run() {
            println("进入不可暂停区域 1。。。");
//            doingLongTime(5);
            println("退出不可暂停区域 1。。。");
        }

    }

    public static void main(String[] args) {
        jqByJoin();
    }

}
