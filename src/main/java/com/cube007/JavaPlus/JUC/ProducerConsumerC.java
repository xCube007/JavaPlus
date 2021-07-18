package com.cube007.JavaPlus.JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerC {

    public static void main(String[] args) {
        Data3 data3 = new Data3();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printA();
            }

        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printB();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data3.printC();
            }
        },"C").start();
    }
}

class Data3 {

    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    int flag = 1;

    public void printA() {
        lock.lock();
        try {
            while (flag != 1) {
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + "开始执行");
            flag = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            while (flag != 2) {
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + "开始执行");
            flag = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            while (flag != 3) {
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + "开始执行");
            flag = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}