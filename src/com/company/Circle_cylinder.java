package com.company;

class Circle{
    protected int radius;
    Circle(){
        System.out.println("No param of circle"); // this will not be called
    }
    Circle(int r){
        this.radius = r;
        //System.out.println("Radius:" + this.radius);
    }

    protected double area(){
        // public access modifier is not compulsory in methods, we can have private and protected too
        return Math.PI*this.radius*this.radius;
    }
}

class Cylinder extends Circle{
    private int height;
    public Cylinder(int r, int h){
        super(r);
        this.height = h;
        System.out.println("Cylinder Volume:"+ this.area()*this.height);
        // here this.area from derived class refers to base class object
    }
    }
class Circle_cylinder {
    public static void main(String[] args) {
        Cylinder obj = new Cylinder(12, 4);

    }
}
