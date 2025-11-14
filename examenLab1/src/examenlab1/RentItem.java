    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examenlab1;

/**
 *
 * @author Hp
 */

import javax.swing.ImageIcon;

public abstract class RentItem {
    
    protected int CodigoItem;
    protected String NombreItem;
    protected double PrecioBase;
    protected int CantCopias;
    protected ImageIcon ImagenItem;
    protected String RutaImagen;
    
    public RentItem(int CodigoItem, String NombreItem, double PrecioBase) {
        this.CodigoItem = CodigoItem;
        this.NombreItem = NombreItem;
        this.PrecioBase = PrecioBase;
        
        CantCopias = 0;
        ImagenItem = null;
    }
    
    @Override
    public String toString() {
        return "Codigo del item: " + CodigoItem + " | Nombre del item: " + NombreItem + " | Precio: " + PrecioBase + " | Cantidad de copias: " + CantCopias;
    }
    
    public abstract double PagoRenta(int dias);

    public int getCodigoItem() {
        return CodigoItem;
    }

    public String getNombreItem() {
        return NombreItem;
    }

    public double getPrecioBase() {
        return PrecioBase;
    }

    public ImageIcon getImagenItem() {
        return ImagenItem;
    }

    public void setImagenItem(ImageIcon ImagenItem) {
        this.ImagenItem = ImagenItem;
    }
    
    
}
