/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab1;

import java.util.Calendar;

/**
 *
 * @author HP
 */
public class Movie extends RentItem{
    private Calendar fechaEstreno = Calendar.getInstance();
    
    public Movie(int CodigoItem, String NombreItem, double PrecioBase){
        super(CodigoItem, NombreItem, PrecioBase);
    }
    
    public Calendar getFechaEstreno(){
        return fechaEstreno;
    }
    
    public void setFechaEstreno(Calendar fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }
    
    public String getEstado(){
       Calendar hoy = Calendar.getInstance();
       if(fechaEstreno.after(hoy)){
           return "ESTRENO";
       }
       
       int years = hoy.get(Calendar.YEAR) - fechaEstreno.get(Calendar.YEAR);
       int months = hoy.get(Calendar.MONTH) - fechaEstreno.get(Calendar.MONTH);
       
       int diferencia = years*12+months;
       
       if(diferencia <= 3){
           return "ESTRENO";
       } else{
           return "NORMAL";
       }

    }

    @Override
    public double PagoRenta(int dias) {
        
        return 0;
        
    }
    
    
}
