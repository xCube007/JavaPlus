package com.cube007.JavaPlus.JUC;

/**
 *
 * @author 11917
 */
public class SaleTicketDemo {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();

        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "C").start();

    }



}

class Ticket {

    private int num = 50;


    // 传统的synchronized
    public synchronized void sale() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "卖了第" + (num--) + "票，剩余：" + num);
        }
    }

}