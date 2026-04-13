package com.company;
/*
Abstract Parent --> Abstract Child (Child2)
Abstract Parent --> Concrete Child (Child1)
 */

abstract class Parent{
    protected Parent(){
        // abstract class has atleast one method that is abstract
        System.out.println("Calling Parent/ Base abstract class constructor ...");
    }
    protected void non_abstract(){
        // abstract class can have non-abstract method
        System.out.println("Calling Parent abstract class's non-abstract method!");
    }
    abstract protected void greet_morn();
    abstract protected void greet_after();
   // abstract void greet_night();
}

class Child1 extends Parent{
    // concrete subclass of an inherited abstract class
    // We cannot extend multiple abstract classes, so we inherited only 1 abstract class
    // This is drawback of abstract class so we use interface for multiple inheritance
    @Override
    protected void greet_morn(){ System.out.println("Good morning in French!");}
    @Override
    protected void greet_after(){
        System.out.println("Good afternoon in French!");
    }
    protected void greet_night() {
        System.out.println("calling method of child1!");
        //  Camera class object of parent cannot access Email method of subclass
    }
}

abstract class Child2 extends Parent{
    private Child2() // all implementing methods of abstract class must be public
    {
        // when an abstract class is inherited, the subclass must provide implementation of all the abstract methods declared
        // in the parent class. If it does not, then it must be declared as abstract
        System.out.println("Calling abstract Child2 class constructor!");
    }
    // no need to write override methods greet morning and greet afternoon as class is already declared abstract
    //abstract child2() ; // This line of constructor is not needed as it already inherits abstract class
}
class abstractclass {
    public static void main(String[] args) {
        //Parent p = new Parent(); -- Error: cannot create object of abstract class
        //Child1 c1 = new Child1(); //No Error
        Parent c = new Child1(); // Can assign reference of an abstract class to object of its concrete subclass
        // Can create reference of abstract class but cannot create object of abstract class
        c.non_abstract();c.greet_morn();c.greet_after();
        //p.greet_night(); //reference of parent abstract class is not allowed to call its inherited subclass method
       //c1.greet_night(); //As Parent class object ref cannot access child class method we write using child class object ref
        // example: if you are given camera interface you cannot call a method (Email/ gps) of smartphone class
        // Reference of Parent class/ interface can only call all methods declared in that interface or parent abstract class
        //Child2 c2 = new Child2(); --  Error: cannot create object of abstract class
       // Parent c2 = new Child2(); //Cannot create object of abstract class
    }
}
