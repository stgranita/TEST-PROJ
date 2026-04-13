package com.company;

interface parent_phone_Interface{
    void make_call();
    void receive_call();
}
interface derived_phone_Interface extends parent_phone_Interface{
    void managecalls();
    void connecttointernet();
}

abstract class samsung_landline_phone implements derived_phone_Interface {
    // same like town hospital not having all facilities of general hospital
    @Override
    public void make_call() { System.out.println("Samsung L/L Making call from phone Interface");}
   @Override
    public void receive_call() { System.out.println("Samsung L/L Receiving call from phone Interface");}
    //abstract void managecalls(); no need as it already implements interface
   // abstract void connecttointernet();  no need as it already implements interface
    }
class smart_phone extends samsung_landline_phone {
   /* public void make_call){
        System.out.println("Calling make_call from parent Interface");
    }
    public void receive_call(){
        System.out.println("Receive call from parent Interface");
    } */ // we may or may not call methods from  parent class by overriding
    @Override
    public void managecalls(){
        System.out.println("Smartphone Managing calls from extended phone Interface");
    }
    @Override
    public void connecttointernet(){
        System.out.println("SmartPhone Connecting to internet from extended phone Interface");
    }
}
public class inheritance_interface { // in one java file there can be only 1 public class
    public static void main(String[] args) {
        smart_phone obj = new  smart_phone();
        obj.make_call();
        obj.receive_call();
        obj.managecalls();
        obj.connecttointernet();
    }
}
