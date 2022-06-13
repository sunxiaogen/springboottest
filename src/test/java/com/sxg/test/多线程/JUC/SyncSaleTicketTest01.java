package com.sxg.test.多线程.JUC;

public class SyncSaleTicketTest01 {
    public static void main(String[] args) {
        Ticket01 ticket = new Ticket01();
        new Thread(()->{
            for (int i = 0; i < 20000; i++) {
                ticket.saleTicket();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 20000; i++) {
                ticket.saleTicket();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 20000; i++) {
                ticket.saleTicket();
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 20000; i++) {
                ticket.saleTicket();
            }
        },"D").start();
    }


}
 class Ticket01{
    int num =20000;
    public synchronized void saleTicket(){
        while (num>0){
            num--; //1.i++ 返回原来的值,++i 返回加1后的值。  2.i++ 不能作为左值,而++i 可以。
            int a =num;
            System.out.println("线程："+Thread.currentThread().getName()+"在售票，"+"卖出第："+(20000-a)+"票，还剩"+num+"票");
        }
    }
}
