package com.sxg.test;

public class Demo02 {
    public static void main(String[] args) {
        Atest atest = new Atest();
        System.out.println(atest.i);
    }
}
class Atest{
    static int i=100;

    static {
        i =500;
        System.out.println("A类static："+i);
    }
    public Atest() {
        System.out.println("A类无参构造器");
    }

}