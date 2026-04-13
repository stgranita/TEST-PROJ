package com.company;
//syntax and logical errors are seen to programmer and run time error is seen to user
// Run time error is an exception, try catch prevents uninterrupted exceptions
// Arithmatic exception, Nullpointer exception, ArryIndexOutofBound Eception, numberformat execption, Illegal Argument excep
class MyNewThr1 extends Thread{
    public void run(){
        int j = 0;
        while(j<4){
            System.out.println("Thread1 Running !" + j + "-->" +  this.getId() + "-->" +this.getPriority());// wait for 2 secs
            try { Thread.sleep(200);} catch (InterruptedException e) {
                System.out.println(e.getMessage());}
            j++;
       }
    }
}

class MyNewThr2 extends Thread{

    public void run(){
        int i =0;
        while(i<4){
            System.out.println("Thread2 running! "+ i + "-->" + this.getId() + "-->" + this.getPriority());
            try { Thread.sleep(200);} catch (InterruptedException e) {
                System.out.println(e);}
       i++; }
    }
}

public class thread_methods {
    public static void main(String[] args){
        MyNewThr1 t1 = new MyNewThr1();
        MyNewThr2 t2 = new MyNewThr2();
        t1.setPriority(9);
        t2.setPriority(6);
        t1.start();
//        try{
//            t1.join();
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }

        t2.start();

    }
}
