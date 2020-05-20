package com.sxg.test;


import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 * 场景二，暂停/恢复
 *
 * “大胖，大胖，先别发请求了，对方服务器快挂了”
 *
 * “好的，好的，等这个执行完就不发了”
 *
 * 过了一会
 *
 * “大胖，大胖，可以重新发请求了”
 *
 * “好的，好的”
 *
 * 要点：把暂停的信号传达给别人，别人处理完手头的事情就自己主动暂停了。但是恢复是无法自主进行的，只能由操作系统来恢复线程的执行。
 *
 * 解说：还是在预设的地点检测flag。然后就是wait/notify配合使用。
 */

public class RunnableTest02 {

    static void pauseByFlag() {
        BRunnable br = new BRunnable();
        new Thread(br).start();
        br.tellToPause();
        try {
            Thread.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        br.tellToResume();
    }

    static class BRunnable implements Runnable {

        volatile boolean pause;

        void tellToPause() {
            pause = true;
        }

        void tellToResume() {
            synchronized (this) {
                this.notify();
            }
        }

        @Override
        public void run() {
            println("进入不可暂停区域 1。。。");
//            doingLongTime(5);
            println("退出不可暂停区域 1。。。");
            println("检测标志pause = %s"+String.valueOf(pause));
            if (pause) {
                println("暂停执行");
                try {
                    synchronized (this) {
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                println("恢复执行");
            }
            println("进入不可暂停区域 2。。。");
//            doingLongTime(5);
            println("退出不可暂停区域 2。。。");
        }

    }

    public static void main(String[] args) {
        pauseByFlag();
    }

}
