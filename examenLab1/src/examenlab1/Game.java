/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab1;

/**
 *
 * @author Hp
 */

import java.util.Calendar;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Game extends RentItem implements MenuActions {
    
    private Calendar FechaPublicacion;
    private ArrayList<String> Especificaciones;
    private static final int PRECIO_RENTA = 20;
    
    public Game(String CodigoItem, String NombreItem, double PrecioBase) {
        super(CodigoItem, NombreItem, PrecioBase);
        
        FechaPublicacion = Calendar.getInstance();
        Especificaciones = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Fecha de Publicacion: " + FechaPublicacion + " - PS3 Game";
    }
    
    public void setFechaPublicacion(int year, int mes, int dia) {
        FechaPublicacion.set(year, mes, dia);
    }
    
    public void listEspecificaciones() {
        if (Especificaciones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Este juego no tiene especificaciones registradas", "Sin especificaciones", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        ListEspecificacionesRec(0, sb);
        
    }
    
    private void ListEspecificacionesRec(int indice, StringBuilder sb) {
        if (indice == Especificaciones.size()) {
            return;
        }
        
        sb.append((indice + 1)).append(".").append(Especificaciones.get(indice)).append("\n");
        ListEspecificacionesRec(indice + 1, sb);
    }
    
    @Override
    public double PagoRenta(int dias) {
        double pago = dias * PRECIO_RENTA;
        
        return pago;
    }
    
    @Override
    public void submenu() {
        int opcion = 0;
        
        do {            
            String eleccion = JOptionPane.showInputDialog(null, """
                                                Submenu - Game
                                                1. Actualizar Fecha de Publicacion
                                                2. Agregar Especificacion
                                                3. Ver Especificaciones
                                                4. Salir
                                                
                                                Ingrese una opcion de las 4 presente para continuar
                                                """, "Submenu", JOptionPane.INFORMATION_MESSAGE);
            
            if (eleccion == null) {
                break;
            }
            
            try {
                opcion = Integer.parseInt(eleccion);
                
                ejecutarOption(opcion);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese una opcion vaalida (de las 4 presentes)");
            }
            
        } while (opcion != 4);
    }
    
    @Override
    public void ejecutarOption(int opcion) {
        
    }
}
