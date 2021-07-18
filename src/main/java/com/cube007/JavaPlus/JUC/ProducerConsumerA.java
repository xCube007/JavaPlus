package com.cube007.JavaPlus.JUC;

/**
 * 用synchronized锁实现生产者消费者问题
 */
public class ProducerConsumerA {

    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();


    }

}

class Data {
    private int number = 0;

    /**
     * +1
     */
    public synchronized void increment() throws InterruptedException {
        // 不能用if 会导致虚假唤醒
        while (number != 0) {
            // 等待
            System.out.println(Thread.currentThread().getName() + "进入等待");
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        this.notify();
    }

    /**
     * -1
     */
    public synchronized void decrement() throws InterruptedException {
        // 不能用if
        while (number == 0) {
            // 等待
            System.out.println(Thread.currentThread().getName() + "进入等待");
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        this.notify();
    }

}

