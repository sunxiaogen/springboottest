package com.sxg.test.多线程.runnable;


import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;

/**
 生产与销售的问题


 在现实中，工厂生产出来的产品会先放到仓库存储，销售人员签了单子后，会从仓库把产品发给客户。

 如果生产的过快，仓库里产品越堆越多，直到把仓库堆满，那就必须停止生产，因为没地方放了。

 此时只能让销售人员赶紧出去签单子，把产品发出去，仓库就有了空间，可以恢复生产了。

 如果销售的过快，仓库里产品越来越少，直到把仓库清空，那就必须停止销售，因为没产品了。

 此时只能让生产人员赶紧生产产品，把产品放到仓库里，仓库里就有了产品，可以恢复销售了。

 可能会有人问，为什么不让生产和销售直接挂钩呢，把仓库这个环节去掉？

 这样会造成两种不好的情况：

 一是突然来了很多单子，生产人员累成死Dog也生产不出来。

 二是很长时间没有单子，生产人员闲成废Dog也无事可做。

 用稍微“专业”点的术语就是此时的生产和销售是一种强耦合的关系，销售的波动对生产影响太大。

 仓库就是一个缓冲区，能有效的吸收波动，很大程度上减少波动的传递，起到一种解耦作用，由强耦合变成一种松散耦合。

 这其实就对应计算机里经典的生产者和消费者问题。


 经典的生产者和消费者


 一到多个线程充当生产者，生产元素。一到多个线程充当消费者，消费元素。

 在两者之间插入一个队列（Queue）充当缓冲区，建立起生产者和消费者的松散耦合。

 正常情况下，即生产元素的速度和消费元素的速度差不多时，生产者和消费者其实是不需要去关注对方的。

 生产者可以一直生产，因为队列里总是有空间。消费者可以一直消费，因为队列里总是有元素。即达到一个动态的平衡。

 但在特殊情况下，比如生产元素的速度很快，队列里没有了空间，此时生产者必须自我“ba工”，开始“睡大觉”。

 一旦消费者消费了元素之后，队列里才会有空间，生产者才可以重启生产，所以，消费者在消费完元素后有义务去叫醒生产者复工。

 更准确的说法应该是，只有在生产者“睡大觉”时，消费者消费完元素后才需要去叫醒生产者。否则，其实可以不用叫醒，因为人家本来就没睡。

 反之，如果消费元素的速度很快，队列里没有了元素，只需把上述情况颠倒过来即可。

 但这样的话就会引入一个新的问题，就是要能够准备的判断出对方有没有在睡大觉，为此就必须定义一个状态变量，在自己即将开始睡大觉时，自己设置下这个变量。

 对方通过检测这个变量，来决定是否进行叫醒操作。当自己被叫醒后，首先要做的就是清除一下这个变量，表明我已经醒来复工了。

 这样就需要多维护一个变量和多了一部分判断逻辑。可能有些人会觉得可以通过判断队列的“空”或“满”（即队列中的元素数目）来决定是否进行叫醒操作。

 在高并发下，可能刚刚判断队列不为空，瞬间之后队列可能已经变为空的了，这样会导致逻辑出错。线程可能永远无法被叫醒。

 因此，综合所有，生产者每生产一个元素后，都会通知消费者，“现在有元素的，你可以消费”。

 同样，消费者每消费一个元素后，也会通知生产者，“现在有空间的，你可以生产”。

 很明显，这些通知很多时候（即对方没有睡大觉时）是没有真正意义的，不过无所谓，只要忽略它们就行了。

 就是“宁可错杀一千，也不放过一个”。首先要保证是正确的，然后才有资格去BB别的。

 解说：其实就是对await/signalAll的应用，几乎面试必问。

 */

public class RunnableTest09 {

    public static void main(String[] args) {
        Queue queue = new Queue();
        new Thread(new Producer(queue)).start();
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

    static class Producer implements Runnable {

        Queue queue;

        Producer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10000; i++) {
//                    doingLongTime();
                    Random random =new Random();
                    queue.putEle(random.nextInt(10000));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    static class Consumer implements Runnable {

        Queue queue;

        Consumer(Queue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10000; i++) {
//                    doingLongTime();
                    queue.takeEle();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    static class Queue {
        Lock lock = new ReentrantLock();
        Condition prodCond  = lock.newCondition();
        Condition consCond = lock.newCondition();

        final int CAPACITY = 10;
        Object[] container = new Object[CAPACITY];
        int count = 0;
        int putIndex = 0;
        int takeIndex = 0;

        public void putEle(Object ele) throws InterruptedException {
            try {
                lock.lock();
                while (count == CAPACITY) {
                    println("队列已满：%d，生产者开始睡大觉。。。"+count);
                    prodCond.await();
                }
                container[putIndex] = ele;
                println("生产元素：%d"+ele);
                putIndex++;
                if (putIndex >= CAPACITY) {
                    putIndex = 0;
                }
                count++;
                println("通知消费者去消费。。。");
                consCond.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public Object takeEle() throws InterruptedException {
            try {
                lock.lock();
                while (count == 0) {
                    println("队列已空：%d，消费者开始睡大觉。。。"+count);
                    consCond.await();
                }
                Object ele = container[takeIndex];
                println("消费元素：%d"+ele);
                takeIndex++;
                if (takeIndex >= CAPACITY) {
                    takeIndex = 0;
                }
                count--;
                println("通知生产者去生产。。。");
                prodCond.signalAll();
                return ele;
            } finally {
                lock.unlock();
            }
        }
    }




}
