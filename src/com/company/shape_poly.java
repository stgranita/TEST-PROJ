package com.company;

abstract class shape
{
        public abstract double getArea();  // Declare an abstract method getArea that returns a double
        public abstract double getPerimeter();  // Declare an abstract method getPerimeter that returns a double
}

class Circle1 extends shape {  // Declare a subclass Circle that extends the Shape class
    private double radius;  // Declare a private double variable radius

    public Circle1(double radius) {  // Define a constructor that takes a double parameter radius
        this.radius = radius;  // Initialize the radius variable with the provided parameter
    }

    @Override  // Override the getArea method from the Shape class
    public double getArea() {  // Define the getArea method
        return Math.PI * radius * radius;  // Calculate and return the area of the circle
    }

    @Override  // Override the getPerimeter method from the Shape class
    public double getPerimeter() {  // Define the getPerimeter method
        return 2 * Math.PI * radius;  // Calculate and return the perimeter of the circle
    }
}

// Subclass Rectangle
class Rectangle extends shape {  // Declare a subclass Rectangle that extends the Shape class
    private double length, width;  // Declare a private double variable length and width

    public Rectangle(double length, double width) {  // Define a constructor that takes two double parameters length and width
        this.length = length;  // Initialize the length variable with the provided parameter
        this.width = width;  // Initialize the width variable with the provided parameter
    }

    @Override  // Override the getArea method from the Shape class
    public double getArea() {  // Define the getArea method
        return this.length * this.width;  // Calculate and return the area of the rectangle
    }

    @Override  // Override the getPerimeter method from the Shape class
    public double getPerimeter() {  // Define the getPerimeter method
        return 2 * (this.length + this.width);  // Calculate and return the perimeter of the rectangle
    }
}


// Main.java
// Main class
public class shape_poly {  // Declare the Main class
    public static void main(String[] args) {  // Define the main method
        Circle1 circle = new Circle1(4.0);  // Create an instance of the Circle class with radius r
        Rectangle rectangle = new Rectangle(4, 6);  // Create an instance of the Rectangle class with sides rs1 and rs2
        System.out.println("Area of the Circle: " + circle.getArea());  // Print the area of the circle
        System.out.println("Perimeter of the Circle: " + circle.getPerimeter());  // Print the perimeter of the circle
        System.out.println("Area of the Rectangle: " + rectangle.getArea());  // Print the area of the rectangle
        System.out.println("Perimeter of the Rectangle: " + rectangle.getPerimeter());  // Print the perimeter of the rectangle
    }// Print the perimeter of the triangle
    }

