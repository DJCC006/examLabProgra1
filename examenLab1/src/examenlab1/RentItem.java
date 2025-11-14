/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab1;

/**
 *
 * @author Hp
 */

public abstract class RentItem {
    
    protected String CodigoItem;
    protected String NombreItem;
    protected double PrecioBase;
    protected int CantCopias;
    
    public RentItem(String CodigoItem, String NombreItem, double PrecioBase) {
        this.CodigoItem = CodigoItem;
        this.NombreItem = NombreItem;
        this.PrecioBase = PrecioBase;
        CantCopias = 0;
    }
    
    @Override
    public String toString() {
        return "Codigo del item: " + CodigoItem + " | Nombre del item: " + NombreItem + " | Precio: " + PrecioBase + " | Cantidad de copias: " + CantCopias;
    }
    
    public abstract double PagoRenta(int dias);

    public String getCodigoItem() {
        return CodigoItem;
    }

    public String getNombreItem() {
        return NombreItem;
    }

    public double getPrecioBase() {
        return PrecioBase;
    }
}
