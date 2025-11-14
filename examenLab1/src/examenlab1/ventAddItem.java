/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author David
 */
public class ventAddItem implements MenuActions {
    
    private ImageIcon imagenGuardada;
     JTextField nombretxt;
     JTextField preciotxt; 
      JLabel imagLb;
      JComboBox opciones;
    JTextField codigotxt = new JTextField();
    
    
    
    public ventAddItem(){
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
        
        JLabel titulo = new JLabel("Agregar Item");
        titulo.setBounds(110, 20, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 50));
        
        
        Object[] data = {"GAME", "MOVIE"};
         opciones = new JComboBox(data);
        opciones.setBounds(110,180 , 200, 30);
        
        JLabel opcionlb = new JLabel("Seleccione el tipo de Item");
         opcionlb.setBounds(100, 130, 200, 50);
         
        JLabel codigolb = new JLabel("Ingrese el codigo del Item");
         codigolb.setBounds(100, 210, 200, 50);
         
         
         
         codigotxt.setBounds(100, 260, 200, 20);
         
         
        JLabel nombrelb = new JLabel("Ingrese el nombre del Item");
         nombrelb.setBounds(100, 310, 200, 50);
         
        nombretxt = new JTextField();
         nombretxt.setBounds(100, 360, 200, 20);
         
        JLabel preciolb = new JLabel("Ingrese el precio base del Item");
         preciolb.setBounds(100, 410, 200, 50);
         
        preciotxt = new JTextField();
         preciotxt.setBounds(100, 460, 200, 20);
         
         
        JButton imagenlb = new JButton("Seleccione la imagen del Item");
         imagenlb.setBounds(400, 130, 280, 30);
         
         imagLb = new JLabel("");
         imagLb.setBounds(400, 180, 280, 300);
         
            imagenlb.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){ 
              
              JFileChooser chooser = new JFileChooser();
              FileNameExtensionFilter filer = new FileNameExtensionFilter("Image Files","jpg", "png");
              chooser.setFileFilter(filer);
              
              int result = chooser.showOpenDialog(screen);
              if(result ==JFileChooser.APPROVE_OPTION){
                  File archivoSelec = chooser.getSelectedFile();
                  imagenGuardada = new ImageIcon(archivoSelec.getAbsolutePath());
                  imagLb.setIcon(imagenGuardada);
                  System.out.println("Se ha seleccionado una imagen");
              }
          }
                    
        });
         
         
         
         
         
         
         
         
        
//          JTextField imagentxt = new JTextField();
//         imagentxt.setBounds(100, 560, 200, 20);
//        
         
         JButton btAdd = new JButton("Agregar Nuevo Item");
         
          btAdd.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){ 
              ejecutarOption(1);
              
              
              
          }
                    
        });
         
        btAdd.setBounds(600, 400, 200, 50);
        
        
        
        
        
        
        
        
        
         JButton btVolver = new JButton("Volver a Menu");
         
          btVolver.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){ 
              screen.dispose();
              menuPrincipal ventana = new menuPrincipal();
          }
                    
        });
      
        btVolver.setBounds(600, 500, 200, 50);
         
         
         
         
        screen.add(codigotxt);
        screen.add(imagLb);
        screen.add(btAdd);
        screen.add(btVolver);
        screen.add(nombretxt);
        screen.add(preciotxt);
       // screen.add(imagentxt);
        screen.add(opcionlb);
        screen.add(codigolb);
        screen.add(nombrelb);
        screen.add(preciolb);
        screen.add(imagenlb);
        screen.add(opciones);
        screen.add(titulo);
        screen.setVisible(true);
        
    }

    @Override
    public void ejecutarOption(int opcion) {
       String tipo =(String) opciones.getSelectedItem();
              if(tipo.equals("GAME")){
                  boolean val1=false;
                  boolean val2=false;
                  
                  String nombre =nombretxt.getText();
                  int codeYes=0;

                 try{
                    int codeMaybe = Integer.parseInt(codigotxt.getText());
                    if(codeMaybe>0 ){
                       codeYes=codeMaybe;
                       val1=true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Codigo Solamente puede ser numeros enteros positivos");
                    }

                }catch(NumberFormatException a)  {
                    JOptionPane.showMessageDialog(null, "Codigo Solamente puede ser numeros enteros");
                }
                 
               
                double priceYes=0;
                
                try{
                    double priceMaybe = Double.parseDouble(preciotxt.getText());
                    priceYes=priceMaybe;
                    val2=true;
                }catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(null, "Precio Solamente puede ser numeros");
                }
                 
                
                
                
                
                
                if(val1==true && val2== true){
                    Game nuevoJuego = new Game(codeYes,nombre,priceYes);
                    nuevoJuego.setImagenItem(imagenGuardada);
                    controladorDatos.getInstancia().getDatos().add(nuevoJuego);
                    JOptionPane.showMessageDialog(null, "JUEGO AGREGADO EXITOSAMENTE");
                    codigotxt.setText("");
                    nombretxt.setText("");
                    preciotxt.setText("");
                    imagLb.setIcon(null);
                    imagenGuardada= null;
                    
                }
                 
              }else if(tipo.equals("MOVIE")){
                  boolean val1=false;
                  boolean val2=false;
                  
                  String nombre =nombretxt.getText();
                  int codeYes=0;

                 try{
                    int codeMaybe = Integer.parseInt(codigotxt.getText());
                    if(codeMaybe>0 ){
                       codeYes=codeMaybe;
                       val1=true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Codigo Solamente puede ser numeros enteros positivos");
                    }

                }catch(NumberFormatException a)  {
                    JOptionPane.showMessageDialog(null, "Codigo Solamente puede ser numeros enteros");
                }
                 
               
                double priceYes=0;
                
                try{
                    double priceMaybe = Double.parseDouble(preciotxt.getText());
                    priceYes=priceMaybe;
                    val2=true;
                }catch(NumberFormatException f){
                    JOptionPane.showMessageDialog(null, "Precio Solamente puede ser numeros");
                }
                 
                
                boolean val3= validacionCodigo(codeYes);
                if(val3==false){
                    JOptionPane.showMessageDialog(null, "CODIGO INVALIDO, YA EXISTE");
                }
                
                
                
                
                if(val1==true && val2== true && val3==true){
                    Game nuevoJuego = new Game(codeYes,nombre,priceYes);
                    nuevoJuego.setImagenItem(imagenGuardada);
                    controladorDatos.getInstancia().getDatos().add(nuevoJuego);
                    JOptionPane.showMessageDialog(null, "PELICULA AGREGADA EXITOSAMENTE");
                    codigotxt.setText("");
                    nombretxt.setText("");
                    preciotxt.setText("");
                    imagLb.setIcon(null);
                    imagenGuardada= null;
                    
                }
              }
    }
    
    
    public static void main(String[] args) {
        ventAddItem ventana = new ventAddItem();
    }
    

    private boolean validacionCodigo(int codigo){
        //for(Abstractclass item: arrayList<serv>){
        boolean validacion =false;
        
        ArrayList<RentItem> items = controladorDatos.getInstancia().getDatos();
        for(RentItem object: items){
            if(codigo==object.getCodigoItem()){
                validacion=true;
            }
        }
          
        
        if(validacion==false){
            return true;
        }
        
        return false;
    }

    
    
}
