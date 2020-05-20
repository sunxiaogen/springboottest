package com.sxg.test;


import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 场景四，叫醒

 “大胖，大胖，醒醒，醒醒，看谁来了”

 “谁啊，我去”

 要点：要把别人从睡梦中叫醒，一定要采取稍微暴力一点的手段。

 解说：线程在sleep或wait时，是处于无法交互的状态的，此时只能使用interrupt方法中断它，线程会被激活并收到中断异常。
 */

public class RunnableTest04 {



    static void stopByInterrupt() {
        DRunnable dr = new DRunnable();
        Thread t = new Thread(dr);
        t.start();
        try {
            println("准备睡2秒");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        println("叫醒");
        t.interrupt();
    }

    static class DRunnable implements Runnable {

        @Override
        public void run() {
            println("进入暂停。。。");
            try {
                println("准备睡5秒");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                println("收到中断异常。。。");
                println("做一些相关处理。。。");
            }
            println("继续执行或选择退出。。。");
        }

    }

    public static void main(String[] args) {
        stopByInterrupt();
    }

}
