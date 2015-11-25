package com.thinking.dyw.balencer;

public class TestInterupted {

    private static Object lock = new Object();
    
    public static void main(String[] args) {
        Thread s1 = new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        lock.wait();
                        System.out.println("ok....");
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        s1.start();
        Thread s2 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    synchronized (lock) {
                        System.out.println("......");
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        s2.start();
    }
    
}
class TestThread extends Thread{

    @Override
    public void run() {
        try {
            longtime();
            System.out.println("continue execute here code...");
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
    }

    private void longtime() throws InterruptedException{
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            
        }
    }
}