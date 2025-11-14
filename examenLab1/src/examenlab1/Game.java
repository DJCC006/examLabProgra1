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
    
    public Game(int CodigoItem, String NombreItem, double PrecioBase) {
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
        
        sb.append((indice + 1)).append(". ").append(Especificaciones.get(indice)).append("\n");
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
        switch(opcion) {
            case 1: //Actualzar fecha de publicacion
                ActualizarFechaPublicacion();
                break;
            case 2: //Agregar especificacion
                AgregarEspecificacion();
                break;
            case 3: //Ver espeficicaciones
                listEspecificaciones();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion erronea", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*
        Opcion 1
    */
    private void ActualizarFechaPublicacion() {
        try {
            //Anio
            String anio = JOptionPane.showInputDialog(null, "Ingrese el año de publicacion", "Actualizar Fecha", JOptionPane.QUESTION_MESSAGE);

            if (anio == null) {
                return;
            }

            int year = Integer.parseInt(anio);

            //Mes
            String mes = JOptionPane.showInputDialog(null, "Ingrese el mes de publicacion (1-12)", "Actualizar Fecha", JOptionPane.QUESTION_MESSAGE);

            if (mes == null) {
                return;
            }

            int month = Integer.parseInt(mes);

            //Dia
            String dia = JOptionPane.showInputDialog(null, "Ingrese el dia de publicacion", "Actualizar Fecha", JOptionPane.QUESTION_MESSAGE);

            if (dia == null) {
                return;
            }

            int day = Integer.parseInt(dia);

            //Actulizar fecha aqui
            setFechaPublicacion(year, month, day);

            JOptionPane.showMessageDialog(null, "La fecha de publicacion se ha actualizado con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Datos invalidos.\nIntente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*
        Opcion 2
    */
    private void AgregarEspecificacion() {
        String especificacion = JOptionPane.showInputDialog(null, "Ingrese la nueva especificacion para añadir", "Agregar especificacion", JOptionPane.QUESTION_MESSAGE);
        
        if (especificacion != null && !especificacion.trim().isEmpty()) {
            Especificaciones.add(especificacion);
            
            JOptionPane.showMessageDialog(null, "Especificacion agregada con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        } else if (especificacion != null) {
            JOptionPane.showMessageDialog(null, "El texto esta vacio, no se va a añadir nada", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
