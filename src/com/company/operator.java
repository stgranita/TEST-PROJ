package com.company;

class thr implements Runnable
{
    boolean exit;
    public thr() {

        System.out.println("Running!");
    }

    @Override
    public void run() {
        while(!exit) {
            System.out.println("Hi");
        }


    }
}
public class operator {
    static int i = 10;

    public static void main(String[] args) {
        thr t = new thr();
        Thread A  = new Thread(t);
        A.start();
        //System.out.println(i++);// first it prints then increases value of i
        // ++i -> first it increases value of i then prints
        //System.out.println(i);
    }
}
