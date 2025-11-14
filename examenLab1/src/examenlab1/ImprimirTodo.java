/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author David
 */
public class ImprimirTodo implements MenuActions{

    public ImprimirTodo(){
        submenu();
    }
    
    
     JPanel panelTarjetas;
    
    @Override
    public void submenu() {
        JFrame screen = new JFrame();
        screen.setSize(1000, 700);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        //screen.setLayout(null);
        
        JLabel titulo = new JLabel("Item Registrados");
        titulo.setBounds(100, 10, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 30));
        
        
        
        panelTarjetas = new JPanel(new GridLayout(0,3,20,20));
        panelTarjetas.setBorder(new EmptyBorder(20,20,20,20));
        
        JScrollPane scrollPane = new JScrollPane(panelTarjetas);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        screen.add(scrollPane,BorderLayout.CENTER);
        
        JButton regresar = new JButton("REGRESAR");
        regresar.setBounds(0, 600, 150, 25);
        
        regresar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){ 
              screen.dispose();
              menuPrincipal ventana = new menuPrincipal();
          }
             
        });
         
        
        
        cargarTarjetas();
        
        screen.add(regresar);
        screen.add(titulo);
        screen.setVisible(true);
    }

    @Override
    public void ejecutarOption(int opcion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
        ImprimirTodo ventana = new ImprimirTodo();
    }
    
    
    private void cargarTarjetas(){
        
        
        
        
        panelTarjetas.removeAll();
        
        ArrayList<RentItem> items = controladorDatos.getInstancia().getDatos();
        if(items.size()<1){
            JLabel text= new JLabel("NO HAY ITEMS");
            text.setFont(new Font("Serif", Font.BOLD,15));
            panelTarjetas.add(text);
            panelTarjetas.setBackground(Color.WHITE);
        }else{
            for(RentItem item: items ){
                JPanel tarjeta = crearTarjeta(item);
                panelTarjetas.add(tarjeta);
            }

            panelTarjetas.revalidate();
            panelTarjetas.repaint();
        }
        
    };
    
    
    
    private JPanel crearTarjeta(RentItem item){
        JPanel tarjeta = new JPanel();
        tarjeta.setLayout(new BorderLayout(5,5));
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY,1),
                new EmptyBorder(5,5,5,5)
        ));
        tarjeta.setPreferredSize(new Dimension(280,450));
        tarjeta.setBackground(Color.WHITE);
        
        JLabel imagenLabel = new JLabel();
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        int width=270;
        int height=280;
        imagenLabel.setPreferredSize(new Dimension(width, height));
        imagenLabel.setBackground(Color.GRAY);
        imagenLabel.setOpaque(true);
        
        
        
        try{
            if(item.RutaImagen!=null){
                File imageFile = new File(item.RutaImagen);
                if(imageFile.exists()){
                    BufferedImage imagenOriginal =  ImageIO.read(imageFile);
                    
                    Image imagenEscalada = imagenOriginal.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    imagenLabel.setIcon(new ImageIcon(imagenEscalada));
                    imagenLabel.setBackground(Color.WHITE);
                }else{
                    imagenLabel.setText("PORTADA NO ENCONTRADA");
                    imagenLabel.setForeground(Color.BLACK);
                }
            }else{
              imagenLabel.setText("SIN PORTADA");
              imagenLabel.setForeground(Color.BLACK);
            }
            imagenLabel.setFont(new Font("Serif", Font.BOLD,14));
        }catch(IOException e){
            imagenLabel.setText("ERROR AL CARGAR LA IMAGEN");
            imagenLabel.setForeground(Color.red);
        }
        
        JTextArea info = new JTextArea();
        info.setText(item.toString());
        info.setEditable(false);
        info.setBackground(Color.WHITE);

        tarjeta.add(imagenLabel, BorderLayout.NORTH);
        tarjeta.add(info, BorderLayout.CENTER);
        
        return tarjeta;
    };
    
    
    
    
}
