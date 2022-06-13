package com.sxg.test.base;

public class outer {
    private int id;

    //在method01方法中有一个Inner内部类，这个内部类就称为局部内部类
    public void method01() {
        class Inner {
            public void in() {
                System.out.println("这是局部内部类");
            }
        }
    }
}
