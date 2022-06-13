package com.sxg.test.多线程.runnable;

public class guitu implements Runnable {


    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i+"步");
            if(isEnd(i)){
                break;
            }
        }
    }
    public boolean isEnd(int steps){
        if(winner!=null){
            System.out.println("获得冠军的是："+winner);
            return true;
        }else {
            if(steps>=100){
                winner =Thread.currentThread().getName();
                System.out.println("获得冠军的是--->>>>："+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        guitu r = new guitu();
        new Thread(r,"兔子").start();
        new Thread(new guitu(),"乌龟").start();
    }

}
