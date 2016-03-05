package br.com.ahe.sd.rmi;

import java.applet.Applet;
import java.awt.Graphics;
import java.rmi.Naming;

public class HelloApplet extends Applet { 

    private static final long serialVersionUID = 1L;
	String message = "nada"; 
    HelloWorld obj = null; 

    public void init() { 
        try { 
            this.obj = (HelloWorld)Naming.lookup("//localhost/HelloWorld"); 
            this.message = this.obj.hello(); 
        } catch (Exception e) { 
            System.out.println("HelloApplet exception: " + e.getMessage()); 
        } 
    } 

    public void paint(Graphics g) { 
        g.drawString(this.message, 25, 50); 
    } 
}


