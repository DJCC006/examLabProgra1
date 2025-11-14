/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab1;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author David
 */
public class ventItems implements MenuActions {

    public ventItems(){
        submenu();
    }
    
    
    @Override
    public void submenu() {
       JFrame screen = new JFrame();
        screen.setSize(1000, 700);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        JLabel titulo = new JLabel("Item Registrados");
        titulo.setBounds(100, 10, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 30));
        
        
        
        
        screen.add(titulo);
        screen.setVisible(true);
    }

    @Override
    public void ejecutarOption(int opcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public static void main(String[] args) {
        ventItems ventana = new ventItems();
    }
}
