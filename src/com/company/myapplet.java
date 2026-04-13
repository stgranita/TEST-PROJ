package com.company;
import java.applet.*;
import java.awt.*;

class myapp {
    public void paint (Graphics g)
    {
      g.drawString("Applet",20,30);
    }


}

public class myapplet {
    public static void main(String[] args) {
        myapp a = new myapp();
    }
}
