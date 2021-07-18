package com.cube007.JavaPlus.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用Lock锁实现生产者消费者问题
 */
public class ProducerConsumerB {

    public static void main(String[] args) {
        Data2 data2 = new Data2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data2.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data2.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data2.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data2.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }

}

class Data2 {
    private int number = 0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    /**
     * +1
     */
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            // 不能用if
            while (number != 0) {
                System.out.println(Thread.currentThread().getName() + "进入等待");
                // 等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * -1
     */
    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            // 不能用if
            while (number == 0) {
                // 等待
                System.out.println(Thread.currentThread().getName() + "进入等待");
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

