package com.company;
// Thread life cycle-->New --> Runnable --> Running --> (non-runnable)/Blocked/Waiting --> Terminated
class MyThreadRunnable1 implements Runnable{
    public void run(){
        int i=0;
        while (i < 4) {
        System.out.println("Running Thread: 1" + i); // Running state
             try {Thread.sleep(1000);} //this is waiting state
             catch (Exception e) {
                System.out.println(e.getMessage()); }
       // Thread scheduler will go to non-runnable state if it waits for io or network and takes another thread
        i++; }
    }
}
class MyThreadRunnable2 implements Runnable{
    public void run(){
        int j=0;
        while (j < 4) {
            System.out.println("I am a thread2:" + j); // Running state
            try {Thread.sleep(1000);} catch (Exception e) {
                System.out.println(e.getMessage()); }
            // Thread scheduler will go to non-runnable state if it waits for io or network and takes another thread
            j++; }
    }
    }

public class ThreadRunnable {
    public static void main(String[] args) {
        MyThreadRunnable1 bullet1 = new MyThreadRunnable1();
        Thread gun1 = new Thread(bullet1); // it is in new state
        MyThreadRunnable2 bullet2 = new MyThreadRunnable2();
        Thread gun2 = new Thread(bullet2); // it is in new state
        // or we can extend thread class, create object of class and obj.start();
        gun1.start(); // It is runnable state
        gun2.start(); // It is runnable state
    }
}
