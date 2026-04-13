package com.company;

class line {
   private int r;
    line() {
       System.out.println("Inside default constructor of base class!");
   }
     line (int r)
    {this.r = r;}

    public int getL() {
        return this.r;
    }

    public void printL() {
        System.out.println("Length:" + this.getL());
    }
}

class squar extends line {
    private int b;
    public squar() {
        System.out.println("Inside default constructor of derived class!");
    }
    public squar (int b) {
        super(b); // without super keyword it will go to the default constructor of base class
        this.b = b;
        System.out.println("Inside overloaded constructor of derived class!");
    }


    public void printArea() {
        System.out.println("Area =" + this.getL()  * this.getL());
    }
}
public class line_circle {
    public static void main(String[] args) {
       //line c = new line(5);
     //   rect r = new rect();
      squar r = new squar (4);
       r.printL();
       r.printArea();
    }


}
