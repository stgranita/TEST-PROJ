package com.company;
//packages in java are used to group related classes. It can be user defined or inbuilt packages like java.util.random, java.util. scanner
public class pattern {
    static void pattern_tri(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
static void pattern_inv(int n)
        {
            for (int i=n;i>0;i--)
            {
                for (int j=0;j<i;j++)
                { System.out.print("*");}
                System.out.println();
            }
            System.out.println();
        }
        static void pattern_recursion(int n)
        {   if (n>0) {
                for (int k = 0; k < n; k++) System.out.print("*");
                System.out.println();
             pattern_recursion(n - 1);
            }
        }

    public static void main(String[] args) {
    //pattern_tri(4);
  //  pattern_inv(4);
    pattern_recursion(4);
    }
}
