
package com.company;
import com.company.access.access_modifier;

import java.util.Date;

class NegativeException extends Exception{
    @Override
    public String toString() {
        return "Value cannot be negative!";
    }

    @Override
    public String getMessage() {
        return "Value cannot be negative!";
    }
}

class access_child extends access_modifier
{
 protected static float div() throws NegativeException, ArithmeticException {
       if (y< 0)  throw new NegativeException();
       return getValue();
          //y is protected modifier can be accessed in same package and also in subclass in different package
           // Here protected is not in same package but we imported the package and  it is a subclass so y can be accessed
     // System.out.println(z); not in this package so cannot access default property
     // static and final method cannot be overridden
    }
}
class using_package {
    public static void main(String[] args) {
        //access_modifier a1 = new access_modifier();
        // System.out.println(a1.y); // protected can accessed in subclass and inside package but here it is outside package and not a subclass so
        // cannot be accessed
       // System.out.println(a1.z); cannot access default outside package
        //System.out.println(a1.a);  cannot access private outside class
        try{  System.out.println( access_child.div());}
        catch(Throwable t) { System.out.println(t.getMessage());}
    }
}
