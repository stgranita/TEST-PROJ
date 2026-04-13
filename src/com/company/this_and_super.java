package com.company;
class Monkey{
    protected int height;

  protected Monkey(int h){
        this.height = h;
        System.out.println("Calling base class overloaded constructor- monkey with parameter: height" + this.height);
    }
   protected int getHeight() {
        return this.height;
    }
    int climb(){
        return this.getHeight() * 4;
    }
} // end of Monkey class
class Human extends Monkey
{
    protected Human(int c) {
    super(c); //without super it will try to call the Base class constructor without parameter, but there is no such constructor
    System.out.println("Calling derived class overloaded constructor - human with parameter: Height" + c + "and can jump" + this.climb());
    //calling super class method from subclass method
    }
    void speak() {
    System.out.println("Sub-class (Human) calling a subclass's method - speak");
    }
}
public class this_and_super {
    public static void main(String[] args)
    {
        //Monkey e = new Monkey(65); allowed
       Human d = new Human(65); //allowed
     // Monkey c = new Human(45);
      // reference is of super class, object is of subclass
        // c.speak() Not allowed as Reference of Parent class/ interface can only call all methods declared in that interface or parent abstract / parent class
        // Derived class object access base class method
        System.out.println("Calling method of monkey class with height" + d.getHeight());
        System.out.println("Calling method of monkey class jump " + d.climb());
        d.speak();
    }
}