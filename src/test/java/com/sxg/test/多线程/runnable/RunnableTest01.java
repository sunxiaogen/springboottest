package com.sxg.test.多线程.runnable;



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
        int count=0 ;
        String isCanCancel = "1";
        int n = 1;

        long interval = 1000;
        //for (int i = 0; i < count; i++) {
        //}
        while(true){
            System.out.println("开始重试通知crm订单--------");
            n++;
            String isCancel = "1";//重试查询crm状态
            if( ("1".equals(isCancel)||"4".equals(isCancel))){
                    System.out.println("第几次"+n);
                    // 通知成功
                if(n>count){
                    break;
                }
                //失败重试3次 每次间隔几分钟
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Long orderId = Long.parseLong("1231312");
        System.out.println(orderId);
    }

}
