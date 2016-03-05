package br.com.ahe.sd.rmi;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.rmi.Naming;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelloGrafico {

    @SuppressWarnings( "unused" )
    private static String labelPrefix = "nada";

    private static HelloWorld obj = null; 

    public Component createComponents() {
        final JLabel label = new JLabel("nada");

        JButton button = new JButton("Ola�!");
        button.setMnemonic(KeyEvent.VK_I);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        	try { 
                    label.setText(obj.hello());
        	} catch (Exception ex) { 
        	    System.out.println("Hello exception: " + ex.getMessage()); 
        	}
            }
        });
        label.setLabelFor(button);

        JPanel pane = new JPanel();
        pane.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        pane.setLayout(new GridLayout(0, 1));
        pane.add(button);
        pane.add(label);

        return pane;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Hello");
        HelloGrafico app = new HelloGrafico();

        Component contents = app.createComponents();
        frame.getContentPane().add(contents, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        try { 
            obj = (HelloWorld)Naming.lookup("//localhost/HelloWorld"); 
        } catch (Exception e) { 
            System.out.println("Hello exception: " + e.getMessage()); 
        } 

   }
}


