package com.company;

class MyThr1 extends Thread{
    public MyThr1(String name){
        super(name);
    }
    public void run() {
        int i = 0;

        while(i<2) {
            try {
                System.out.println("Running Threads:" + this.getId() + "-->" + this.getName()+ "-->" + this.getPriority());
                i++;
               try { Thread.sleep(5000); }
               catch (InterruptedException e) {
                   System.out.println(e.getMessage());
               }
            } catch (Exception e) {
                System.out.println(e.getMessage()); }
            }
        }

    }

public class thread_priority {
    public static void main(String[] args) {
        // Ready Queue: T1 T2 T3 T4 T5
        MyThr1 t1 = new MyThr1("Rani1");
        MyThr1 t2 = new MyThr1("Rani2");
        MyThr1 t3 = new MyThr1("Rani3");
        MyThr1 t4 = new MyThr1("Rani4");
        MyThr1 t5 = new MyThr1("Rani5");
        t5.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
 // you can also write t1.getID, t1.getName();
    }
}
