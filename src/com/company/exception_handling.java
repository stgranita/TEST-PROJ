package com.company;

import java.util.Scanner;

public class exception_handling{
    public static void main(String[] args) {
        int [] marks = new int[3];
        marks[0] = 7;
        marks[1] = 56;
        marks[2] = 6;
        Scanner sc = new Scanner(System.in);
        try{
        System.out.println("Enter the array index");
        int ind = sc.nextInt();

        System.out.println("Enter the number you want to divide the value with");
        int number = sc.nextInt();

            System.out.println("The value at array index entered is: " + marks[ind]);
            System.out.println("The value of array-value/number is: " + marks[ind]/number);
          //  throw new Exception();
        }
        catch (ArithmeticException e){
            System.out.println("ArithmeticException occured!" + e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException occured!" + e.toString());
            // e.toString()); is same as e
        }
        catch (Exception e){
            System.out.println("Other exception occured!" + e);
            e.printStackTrace();
        }
    }
}
