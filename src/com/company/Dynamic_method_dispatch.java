package com.company;
class Phone{
    int m;
    void call(){ System.out.println("Calling from Phone");}
    public void on(){
        System.out.println("Turning on Phone...");
    }
}

class SmartPhone extends Phone{
    void music(){ System.out.println("Playing music..." + m);}
    //Default variable can be accessed in subclass only if subclass is in same package
    @Override
    // Method Override needs to be on methods with same parameter and same access modifier.
    // static and final methods cannot be performed for overriden methods
    public void on(){ System.out.println("Turning on SmartPhone...");}


}
public class Dynamic_method_dispatch {
    public static void main(String[] args) {
        Phone Phn = new Phone();
       // SmartPhone obj2 = new SmartPhone(); // Allowed
        Phone SPhn = new SmartPhone(); // Object of subclass is created with reference to superclass
        // here object creation is at run time so it is called run-time polymorphism
        SPhn.call();
        SPhn.on(); // this is dynamic method dispatch
        Phn.on(); //It will call parent class 'on' method
        //SPhn.music(); // Allowed
       //  Phn.music(); //Important:Not Allowed as Superclass reference cannot access subclass method



    }
}
