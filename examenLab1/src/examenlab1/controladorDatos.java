/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab1;

import java.util.ArrayList;

/**
 *
 * @author David
 */
public class controladorDatos {
     private static controladorDatos instancia;
    
    private ArrayList<RentItem> datosG;
    
    private controladorDatos(){};
    
    public static controladorDatos getInstancia(){
        if(instancia==null){
            instancia= new controladorDatos();
        }
        return instancia;
    }
    
    public ArrayList<RentItem> getDatos(){
        return datosG;
    }
    
    public void setDatos(ArrayList<RentItem> datos){
        datosG=datos;
    }
}
