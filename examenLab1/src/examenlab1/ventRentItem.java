/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author David
 */
public class ventRentItem implements MenuActions {

    
    
    public ventRentItem(){
        submenu();
    }
    
    
    @Override
    public void submenu() {
        JFrame screen = new JFrame();
        screen.setSize(900, 700);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        JLabel titulo = new JLabel("Rentar Item");
        titulo.setBounds(110, 20, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 50));
        
        JLabel codigolb = new JLabel("Ingrese el codigo del Item");
         codigolb.setBounds(100, 100, 200, 50);
         
            JTextField buscartxt = new JTextField();
         buscartxt.setBounds(100, 160, 200, 20);
         
         
      
         
         
        JLabel tipolb = new JLabel("Tipo de Item");
         tipolb.setBounds(100, 200, 150, 50);
         
           JTextField tipotxt = new JTextField();
         tipotxt.setBounds(100, 260, 150, 20);
         tipotxt.setEnabled(false);
         
        JLabel nombrelb = new JLabel("Nombre de Item");
         nombrelb.setBounds(300, 200, 150, 50);
         
           JTextField nombretxt = new JTextField();
         nombretxt.setBounds(300, 260, 150, 20);
         nombretxt.setEnabled(false);
         
         
        JLabel preciolb = new JLabel("Precio Base de Item");
         preciolb.setBounds(500, 200, 150, 50);
         
           JTextField preciotxt = new JTextField();
         preciotxt.setBounds(500, 260, 150, 20);
         preciotxt.setEnabled(false);
         
         
         JLabel imaglb = new JLabel("imag");
         imaglb.setBounds(100, 310, 200, 500);
         
         
           JLabel rentalb = new JLabel("Monto Total de Renta");
         rentalb.setBounds(700, 200, 150, 50);
         
           JTextField rentatxt = new JTextField();
         rentatxt.setBounds(700, 260, 150, 20);
         rentatxt.setEnabled(false);
         
         
         
         
         
        JButton buscarnt = new JButton("Buscar Item");
         buscarnt.setBounds(400, 130, 150, 30);
         
         
            buscarnt.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){ 
             
              
          }
                    
        });
         
         
         
         
         
         
         
         
        
//          
         
         JButton btAdd = new JButton("Rentar Item");
         
          btAdd.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){ 
          }
             
        });
         
        btAdd.setBounds(600, 400, 200, 50);
        
        
        
        
        
        
        
        
        
         JButton btVolver = new JButton("Volver a Menu");
         
          btVolver.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){ 
          }
                    
        });
      
        btVolver.setBounds(600, 500, 200, 50);
         
         
         
         
        //screen.add(codigotxt);
        screen.add(buscarnt);
        screen.add(imaglb);
        screen.add(tipolb);
        screen.add(rentalb);
        screen.add(rentatxt);
        screen.add(tipotxt);
        screen.add(buscartxt);
        screen.add(btAdd);
        screen.add(btVolver);
        screen.add(nombretxt);
        screen.add(preciotxt);
       // screen.add(imagentxt);
       // screen.add(opcionlb);
        screen.add(codigolb);
        screen.add(nombrelb);
        screen.add(preciolb);
       // screen.add(imagenlb);
        //screen.add(opciones);
        screen.add(titulo);
        screen.setVisible(true);
        
    }

    @Override
    public void ejecutarOption(int opcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public static void main(String[] args) {
        ventRentItem ventana = new ventRentItem();
    }
    
    
    
}
