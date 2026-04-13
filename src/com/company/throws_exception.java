package com.company;
import java.io.IOException;
import java.util.Scanner;

class NegativeRadiusException extends Exception{
    @Override
    public String toString() {
        return "Radius should be positive!";
    }

    @Override
    public String getMessage() {
        return "Radius should be positive!";
    }
}

public class throws_exception {

    public static double area(float r) throws NegativeRadiusException {
        if (r <= 0) throw new NegativeRadiusException();
        return Math.PI * r * r;
    }

    public static float div(float a, int b) throws IOException, ArithmeticException {
        if (b == 0) throw new ArithmeticException(("/ by 0"));
        return (float) a / b;
    }

    public static void main(String[] args) {
        boolean flag = true;
        do {
            System.out.println("Enter diameter of circle (in cm)");
            Scanner sc = new Scanner(System.in);
            Float a = sc.nextFloat();
            try {
              //  System.out.println("Radius is " + div(a, 2));
                System.out.println("Area is " + area(div(a, 2)));
            } catch (IOException e1) {
                System.out.println("IO Exception: " + e1.getMessage());
            } catch (ArithmeticException e1) {
                System.out.println("Arithmatic Exception:" + e1.getMessage());
            } catch (NegativeRadiusException e1) {
                System.out.println("Negative Radius Exception:" + e1.getMessage());
            } catch (Exception e1) {
               System.out.println("Some Other Exception:" + e1.getMessage());
            break; }
            finally { // finally has code that will always get executed
                System.out.println("Continue? (1/0)");
                Scanner sc1 = new Scanner(System.in);
                int c = sc1.nextInt();
                if (c == 0) break;
            }
        } while (flag == true);
    }
}