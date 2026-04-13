package com.company;

import java.util.Scanner;

public class nested_try_catch {
    public static void main(String[] args) {
        int [] marks = new int[3];
        marks[0] = 7;
        marks[1] = 56;
        marks[2] = 6;
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("Enter the index to access");
            int ind = sc.nextInt();
            System.out.println("Enter the number to divide with");
            int num = sc.nextInt();
            try {
                System.out.println("Inside Level1 of try:" + marks[ind]);
                flag = false;
                try {
                    System.out.println("Inside level 2 of try:" + (float)(marks[ind]/num));
                    flag = false;
                } catch (ArithmeticException e1) {
                    flag = true;
                    System.out.println("Level 2:" + e1.getMessage());
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                flag = true;
                System.out.println("Level1:" + e2.getMessage());
            }
            if (flag == true) System.out.println("Exeception Caught!");
        }
    }
}
