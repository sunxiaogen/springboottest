package com.sxg.test;

import java.util.concurrent.atomic.AtomicInteger;

public class JUCTest01 {
    //J.U.C 包里面的整数原子类 AtomicInteger，
    // 其中的 compareAndSet() 和 getAndIncrement() 等方法都使用了 Unsafe 类的 CAS 操作。
    // 以下代码使用了 AtomicInteger 执行了自增的操作。
    private AtomicInteger cnt = new AtomicInteger();

    public void add(){
        cnt.incrementAndGet();
    }

}
