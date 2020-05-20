package com.sxg.test;


import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Phaser;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 事件四，魔性游戏

 这是一个充满魔性的小游戏，由一个团队一起参加。所有人每隔5秒钟抽一次签，每个人有50%的概率留下来或被淘汰。

 留下来的人下次抽签时同样有50%的概率被淘汰。被淘汰的人下次抽签时同样有50%的概率复活。

 团队所有成员都被淘汰完，为挑战失败，团队所有成员都回到游戏中（除刚开始外），为挑战成功。

 比如一开始10人参与游戏，第一轮抽签后，6人留下，4人淘汰。

 第二轮抽签后，留下的6人中4人被淘汰，淘汰的4人中2人复活，那么目前是4人在游戏中，6人被淘汰。

 一直如此继续下去，直到10人全部被淘汰，或全部回到游戏中。

 可见，人数越多，全部被淘汰的概率越小，但全部回到游戏中的概率也越小。

 反之，人数越少，全部回到游戏中的概率越大，但全部被淘汰的概率也越大。

 是不是很有魔性啊。哈哈。


 解说：某个线程到达预设点后，可以选择等待同伴或自己退出，等大家都到达后，再一起向下一个预设点出发，随时都可以有新的线程加入，退出的也可以再次加入。

 */

public class RunnableTest08 {

    static final int COUNT = 6;

    public static void main(String[] args) throws Exception {
        new Thread(new Challenger("张三")).start();
        new Thread(new Challenger("李四")).start();
        new Thread(new Challenger("王五")).start();
        new Thread(new Challenger("赵六")).start();
        new Thread(new Challenger("大胖")).start();
        new Thread(new Challenger("小白")).start();
        synchronized (RunnableTest08.class) {
            RunnableTest08.class.wait();
        }
    }

    static Phaser ph = new Phaser() {

        protected boolean onAdvance(int phase, int registeredParties) {
            println("第"+phase+"局，剩余"+registeredParties+"人");
            return registeredParties == 0 ||
                    (phase != 0 && registeredParties == COUNT);
        };
    };

    static class Challenger implements Runnable {

        String name;
        int state;

        Challenger(String name) {
            this.name = name;
            this.state = 0;
        }

        @Override
        public void run() {
            println(name+"开始挑战。。。");
            ph.register();
            int phase = 0;
            int h;
            while (!ph.isTerminated() && phase < 100) {
//                doingLongTime(5);
                if (state == 0) {
                    if (Decide.goon()) {
                        h = ph.arriveAndAwaitAdvance();
                        if (h < 0)
                            println(phase+name+"继续，但已胜利。。。");
                        else
                            println(phase+name+"继续"+h+"。。。");
                    } else {
                        state = -1;
                        h = ph.arriveAndDeregister();
                        println(phase+name+"退出"+h+"。。。");
                    }
                } else {
                    if (Decide.revive()) {
                        state = 0;
                        h = ph.register();
                        if (h < 0)
                            println(phase+name+"复活，但已失败。。。");
                        else
                            println(phase+name+"复活"+h+"。。。");
                    } else {
                        println(phase+name+"没有复活。。。");
                    }
                }
                phase++;
            }
            if (state == 0) {
                ph.arriveAndDeregister();
            }
            println(name+"结束。。。");
        }

    }

    static class Decide {

        static boolean goon() {
            Random random =new Random();
            return random.nextInt(9) > 4;
        }

        static boolean revive() {
            Random random =new Random();
            return random.nextInt(9) < 5;
        }
    }



}
