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
public class Ejecuter {
    
    public static void main(String[] args) {
        ArrayList<RentItem> items = new ArrayList<>();
        controladorDatos.getInstancia().setDatos(items);
        menuPrincipal ventana = new menuPrincipal();
    }
    
    
}
