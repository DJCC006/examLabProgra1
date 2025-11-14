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

        switch (getEstado()) {

            case "ESTRENO":

                if (dias > 2) {
                    return super.getPrecioBase() + ((dias - 2) * 50);
                } else {
                    return super.getPrecioBase();
                }
            case "NORMAL":

                if (dias > 5) {
                    return super.getPrecioBase() + ((dias - 5) * 30);
                } else {
                    return super.getPrecioBase();
                }
            default:
                return 0;

        }
    }
    
    @Override
    public String toString(){
        String precio = (PrecioBase > 0) ? String.format("Lps.%.2f", PrecioBase) : "N/A";
        return "- Movie\n"
                + "\n | Codigo: "+CodigoItem
                + "\n | Nombre: "+NombreItem
                + "\n | Precio de Renta: "+precio
                + "\n | Estado :"+getEstado();
    }
}
