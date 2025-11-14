/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class menuPrincipal implements MenuActions{
    
    public static ArrayList<RentItem> itemsRentados = new ArrayList<>();;
    
    
    
    
    public menuPrincipal(){
        
        submenu();
    }
    
    
    

    @Override
    public void submenu() {
        JFrame screen = new JFrame();
        screen.setSize(600, 800);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        
        
         JLabel titulo = new JLabel("MENU PRINCIPAL");
        titulo.setBounds(110, 50, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 50));
        
        
         JButton btAgregar = new JButton("Agregar Item");
        btAgregar.setBounds(200, 180, 200, 50);
       
    
        
        btAgregar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){ 
              screen.dispose();
              ventAddItem ventana = new ventAddItem();
          }
                    
        });
         JButton btRentar = new JButton("Rentar Item");
        btRentar.setBounds(200, 300, 200, 50);
        
    
        
        btRentar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){ 
              screen.dispose();
              ventRentItem ventana = new ventRentItem();
          }
                    
        });
        
        
         JButton btMostrar = new JButton("Mostrar Items");
        btMostrar.setBounds(200, 420, 200, 50);
      
    
        
        btMostrar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){ 
              screen.dispose();
              ImprimirTodo ventana = new ImprimirTodo();
          }
                    
        });
         JButton btSalir = new JButton("Salir");
        btSalir.setBounds(200, 520, 200, 50);
      
    
        
        btSalir.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){ 
              screen.dispose();
          }
                    
        });
        
        
        
        
        screen.add(btAgregar);
        screen.add(btSalir);
        screen.add(titulo);
        screen.add(btRentar);
        screen.add(btMostrar);
        screen.setVisible(true);
    }

    @Override
    public void ejecutarOption(int opcion) {
        
        
    }
    
    
    
    public static void main(String[] args) {
        menuPrincipal vetnana = new menuPrincipal();
    }
}
