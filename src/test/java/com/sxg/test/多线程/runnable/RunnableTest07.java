package com.sxg.test.多线程.runnable;


import java.util.concurrent.Exchanger;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 事件三，劳动

 大胖和小白去了创业公司，公司为了节约开支，没有请专门的保洁人员。让员工自己扫地和擦桌。

 大胖觉得擦桌轻松，就让小白去扫地。可小白觉得扫地太累，也想擦桌。

 为了公平起见，于是决定，每人先干一半，然后交换工具，再接着干对方剩下的那一个半。

 解说：两个线程在预设点交换变量，先到达的等待对方。

 */

public class RunnableTest07 {

    public static void main(String[] args) throws Exception {
        new Thread(new Staff("大胖", new Tool("笤帚", "扫地"), ex)).start();
        new Thread(new Staff("小白", new Tool("抹布", "擦桌"), ex)).start();
        synchronized (RunnableTest07.class) {
            RunnableTest07.class.wait();
        }
    }

    static Exchanger<Tool> ex = new Exchanger<>();

    static class Staff implements Runnable {

        String name;
        Tool tool;
        Exchanger<Tool> ex;

        Staff(String name, Tool tool, Exchanger<Tool> ex) {
            this.name = name;
            this.tool = tool;
            this.ex = ex;
        }

        @Override
        public void run() {
            println(name+"拿的工具是"+tool.name+"他开始"+tool.work+"。。。");
//            doingLongTime();
            println(name+"开始交换工具。。。");
            try {
                tool = ex.exchange(tool);
            } catch (Exception e) {
                e.printStackTrace();
            }
            println(name+"的工具变为"+tool.name+"他开始"+tool.work+"。。。");
        }

    }

    static class Tool {

        String name;
        String work;

        Tool(String name, String work) {
            this.name = name;
            this.work = work;
        }

    }



}
