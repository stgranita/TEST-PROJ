package com.company;
// interface is a point where two systems meet and interact.
// Interface has group of related abstract methods or with empty bodies
interface Bicycle{
     int wheels=4 ; // This is a propoerty of interface which are always  final
    // or we can also make wheels as static in Avon Cycle
    // as static is not a part of the object but part of class
   // all properties and variables of interface and class that implements interface are public
   // methods in an interface are public by default. we need not explicitly write pblic here
    void applyBrake(int decrement);
    void speedUp(int increment);
}
interface HornBicycle{
    int wheels2 = 4;
    void playSong1();
    void playSong2();
}
class AvonCycle implements Bicycle, HornBicycle{
    int speed=1;
    int wheels1= 0, wheels2=0;
    //allowed to override in inherited class but not needed (as properties of interface are final)
    // it is not necessary to override the variables or properties Wheel1 and Wheel2 in class that implements interface
    void blowHorn(){
        // Individual Methods not from interface need not be declared public
        System.out.println("Avon Cycle Honking...");
    }
    // Methods from interface must be declared public
    public void applyBrake(int decrement){
        this.speed = this.speed - decrement; // allowed as it is overriden property
        System.out.println("Bicycle: Applying Brake, Changing speed to:" + this.speed + "with wheels" + wheels1);
    }
    public void speedUp(int increment){
        this.speed = this.speed + increment;
        System.out.println("Bicycle: Applying SpeedUP, Changing speed to:"+this.speed + "with wheels" + wheels1);
    }
    public void playSong1(){ System.out.println("Horn Bicycle: Song1!!" + "with wheels" + wheels2);
    }
    public void playSong2(){
        System.out.println("Horn Bicycle: Song2!!" + "with wheels" + wheels2);
    }
    public void individual_avon(){
        System.out.println("Avon cycle honking!");
    }
}
public class interface_demo{
    public static void main(String[] args) {
        AvonCycle c1 = new AvonCycle(); // class implementing 2 interface
        // we can create reference of interface but cannot create object of interface
        // As Superclass reference cannot access subclass method blowhorn() we created object of subclass Avoncycle
        System.out.println("No. of wheels for BiCycle and Horn Cycle are:" + c1.wheels1 + " and " + c1.wheels2);
        System.out.println("Speed:" + c1.speed);
        // It will always call interface properties
        // You cannot modify the properties or fields in Interfaces as they are final
        // You can create properties in Interfaces and access them through object of class that implements interface
       //c1.wheels = 45; //You can only aceess but you are not allowed to reassign as properties of interface
        c1.blowHorn(); // Method of Avon cycle
        c1.applyBrake(1); // Method from Bicycle interface
        c1.speedUp(2); // Method from Bicycle interface
        c1.playSong1(); // Method from Horn cycle interface
        c1.playSong2(); // Method from Horn cycle interface
        c1.individual_avon();
       /* Bicycle b = new AvonCycle(); HornBicycle h = new AvonCycle();
        h.applybreak(); b.playSong1(); calling another interface method is not allowed
        b.individual_avon(); Not allowed as superclass cannot access subclass method*/
    }
}
