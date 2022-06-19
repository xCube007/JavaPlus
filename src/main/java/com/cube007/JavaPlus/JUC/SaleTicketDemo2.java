package com.cube007.JavaPlus.JUC;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo2 {

    public static void main(String[] args) {

        Ticket2 ticket2 = new Ticket2();

        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket2.sale();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket2.sale();
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket2.sale();
            }
        }, "C").start();

    }



}

// Lock锁
class Ticket2 {

    private int num = 50;

    Lock lock = new ReentrantLock();

    public  void sale() {
        // 加锁
        lock.lock();

        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖了第" + (num--) + "票，剩余：" + num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 解锁
            lock.unlock();
        }
    }


}
