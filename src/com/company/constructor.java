package com.company;
class employee
{

    private int id;
    private String name;
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public employee(int no, String na) //constructors can take parameters without being overloaded
    {
        // there can be more than 2 overloaded constructors
        this.id = no;
        this.name = na;
    }

    public String getName()
    {
     return this.name;
    }

    public int getID()
    {
        return this.id;
    }

}
public class constructor {
    public static void main(String[] args) {
        employee e = new employee(40, "Coding");
        //e.setID(42); e.setName("Programming");
        System.out.println(e.getID() + "-->" + e.getName());
    }
}
