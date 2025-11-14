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
        
        JLabel titulo = new JLabel("MENU PRINCIPAL");
        titulo.setBounds(110, 50, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 50));
        
        
        
        
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
