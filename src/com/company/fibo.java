package com.company;

import java.util.Scanner;

public class fibo {
    static int fib(int n) {
        if (n==1 || n==2) return n-1; // base condition
        return fib(n-1) + fib(n-2);

    }
    public static void main(String[] args) {
        System.out.println("Enter for how many terms you want to calculate (n>0):");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(fib(a));
    }
}
