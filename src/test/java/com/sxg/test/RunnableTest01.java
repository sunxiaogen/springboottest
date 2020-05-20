package com.sxg.test;



import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 * 场景一，停止
 *
 * “大胖，大胖，12点了，该去吃饭了，别写了”
 *
 * “好的，好的，稍等片刻，把这几行代码写完就走”
 *
 * 要点：把停止的信号传达给别人，别人处理完手头的事情就自己主动停止了。
 *
 * 解说：线程在预设的地点检测flag，来决定是否停止。
 */

public class RunnableTest01  {

    static void stopByFlag() {
        ARunnable ar = new ARunnable();
        new Thread(ar).start();
        ar.tellToStop();
    }

    static class ARunnable implements Runnable {

        volatile boolean stop;

        void tellToStop() {
            stop = true;
        }

        @Override
        public void run() {
            println("进入不可停止区域 1。。。");
//            doingLongTime(5);
            println("退出不可停止区域 1。。。");
            println("检测标志stop = %s"+ String.valueOf(stop));
            if (stop) {
                println("停止执行");
                return;
            }
            println("进入不可停止区域 2。。。");
//            doingLongTime(5);
            println("退出不可停止区域 2。。。");
        }

    }

    public static void main(String[] args) {
        stopByFlag();
    }

}
