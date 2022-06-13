package com.sxg.test.多线程.JUC;

public class SaleTicketTest01 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        System.out.println("===A===");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20000; i++) {
                    ticket.saleTicket();
                }
            }
        },"A").start();
        System.out.println("===B===");
        new Thread(()->{
            for (int i = 0; i < 20000; i++) {
                ticket.saleTicket();
            }
        },"B").start();
        System.out.println("===C===");
        new Thread(()->{
            for (int i = 0; i < 20000; i++) {
                ticket.saleTicket();
            }
        },"C").start();
        System.out.println("===D===");

        new Thread(()->{
            for (int i = 0; i < 20000; i++) {
                ticket.saleTicket();
            }
        },"D").start();
    }


}
class Ticket{
    int num =20000;
    public void saleTicket(){
        if (num>0){
            num--; //1.i++ 返回原来的值,++i 返回加1后的值。  2.i++ 不能作为左值,而++i 可以。
            int a =num;
            System.out.println("线程："+Thread.currentThread().getName()+"在售票，"+"卖出第："+(20000-a)+"票，还剩"+num+"票");
        }
    }
}
