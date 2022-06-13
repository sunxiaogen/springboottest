package com.sxg.test.多线程.callable;


import java.util.concurrent.*;

public class CallableTest01 implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        return true;
    }

    public static void main(String[] args) {
        CallableTest01 callableTest01 = new CallableTest01();
//         创建执行服务：
        ExecutorService ser =Executors.newFixedThreadPool(1);
//         提交执行：
        Future<Boolean> result1 = ser.submit(callableTest01);
//         获取结果：
        boolean r1 = false;
        try {
            r1 = result1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(r1);
//         关闭服务：
        ser.shutdownNow();
    }
}
