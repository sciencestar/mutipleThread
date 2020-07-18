package com.mutiplethread.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName ThreadTest5
 * @Description: TODO
 * @Author lxc
 * @Date 2020/7/18 15:03
 * @Version V1.0
 **/
public class ThreadTest5 {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadTest5.class);

    public static void main(String[] args) throws InterruptedException {
        final Object object = new Object();

        Thread.sleep(1 * 1000);
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    try {
                        Thread.sleep(2 * 1000);
                        LOGGER.info("wait start---------------,threadName->{}", Thread.currentThread().getName());
                        object.wait();
                        LOGGER.info("wait end---------------,threadName->{}", Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        LOGGER.error("InterruptedException error", e);
                    }
                }
            }
        }, "A");
        threadA.start();

        Thread.sleep(1 * 1000);
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    try {
                        Thread.sleep(2 * 1000);
                        LOGGER.info("wait start---------------,threadName->{}", Thread.currentThread().getName());
                        object.wait();
                        LOGGER.info("wait end---------------,threadName->{}", Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        LOGGER.error("InterruptedException error", e);
                    }
                }
            }
        }, "B");
        threadB.start();

        Thread.sleep(1 * 1000);
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    try {
                        Thread.sleep(2 * 1000);
                        LOGGER.info("wait start---------------,threadName->{}", Thread.currentThread().getName());
                        object.wait();
                        LOGGER.info("wait end---------------,threadName->{}", Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        LOGGER.error("InterruptedException error", e);
                    }
                }
            }
        }, "C");
        threadC.start();

        Thread.sleep(1 * 1000);
        Thread threadD = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    try {
                        Thread.sleep(2 * 1000);
                        LOGGER.info("notify start---------------,threadName->{}", Thread.currentThread().getName());
                        object.notifyAll();
                        LOGGER.info("notify end---------------,threadName->{}", Thread.currentThread().getName());

                        /*LOGGER.info("notify start---------------,threadName->{}", Thread.currentThread().getName());
                        object.notify();
                        LOGGER.info("notify end---------------,threadName->{}", Thread.currentThread().getName());

                        LOGGER.info("notify start---------------,threadName->{}", Thread.currentThread().getName());
                        object.notify();
                        LOGGER.info("notify end---------------,threadName->{}", Thread.currentThread().getName());*/
                    } catch (InterruptedException e) {
                        LOGGER.error("InterruptedException error", e);
                    }
                }
            }
        }, "D");
        threadD.start();

        Thread.sleep(10 * 1000);
        LOGGER.info("threadA state->{}", threadA.getState());
        LOGGER.info("threadB state->{}", threadB.getState());
        LOGGER.info("threadC state->{}", threadC.getState());
        LOGGER.info("threadD state->{}", threadD.getState());
    }
}
