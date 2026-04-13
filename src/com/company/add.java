package com.company;
import com.company.access.*;
class add {
    protected static int u, z;
    //The protected access modifier, along with public, private, can only
    // be applied to member variables (fields) at the class level, not local variables
   protected static int addnum(int x, int y)
    {   u =x +y;
        z = x-y;
        if (x>y)
          // cannot access non-static variable from static method so z was made static
        return z;
        else
        return y;


    }
    public static void main(String[] args) {
       // add obj = new add();
        System.out.println(add.addnum (-6,-2) + " when difference is " + add.z); //this is statically calling,
        // non statically obj.addnum(2,4);
        }
    }

