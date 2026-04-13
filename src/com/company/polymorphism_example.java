package com.company;
interface camera1 {
    void take_Snap();
    void record_Video();
}
interface wifi1 {
   String [] network_list();
   void connect_Network(String work);
}

class phone {
    void call_number(String num) { System.out.println("Calling number" + num);}
    void receiving_call() { System.out.println("connecting...");}
}
class smartphone1 extends phone implements camera1, wifi1 {
    public void take_Snap() { System.out.println(" Click..Click..");}
    public void record_Video() { System.out.println("Taking Video!");}
    public  String [] network_list() { String [] nlist = {"asus3G", "PG1956", "olive2007"}; return nlist; }
    public void connect_Network(String work) { System.out.println("Connecting to..." + work);};
    }
public class polymorphism_example
{
    public static void main(String[] args) {
        smartphone1 sp = new smartphone1();
        camera1 c = new smartphone1();
        wifi1 w = new smartphone1();
        String arr[] = sp.network_list();
        for(String s: arr) System.out.println(s);
        sp.connect_Network("PG1956"); // Object of class that implements interface is calling interface methods
        sp.call_number("302423");
        w.connect_Network("olive2007"); // object reference of interface used for calling interface method
        sp.receiving_call();
        sp.take_Snap();
        c.take_Snap();
        c.record_Video(); //but camera cannot connect network or get list of avaialble networks
        sp.record_Video();
    }
}
