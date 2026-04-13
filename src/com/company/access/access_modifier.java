package com.company.access;
/*   -->>     class  inside package   Subclass Outside Package
public-x        Y        Y               Y        Y
protected-y     Y        Y               Y        Y (only if subclass is in same/ another package we can access protected variable
default(no)-z   Y        Y               Y        N
private -a      Y        N               N        N
 */
// Only public is referred outside  package
public class access_modifier {
    private int a = -45;
    private static int x = 78;
    protected static int y=0; // // protected modifier can be accessed in same package and also in subclass
    static int z = 6;
    //   Default variable can be accessed in subclass only if suclass is in same package

    protected static int getValue() {
        return x+y+z;
     // suppose if get Y was in a subclass that is in different file that imports the package 'access', we can  use y
    }
    public static void main(String[] args) {
        System.out.println(getValue());
     // System.out.println(access_modifier.a); //private property cannot be accessed outside class
        // but we can create a method and access the private property
    }
}

