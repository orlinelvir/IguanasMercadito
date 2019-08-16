package edu.ujcv.progra2.company;

public class Producto {
    private String NombreDeProducto;
    private float PrecioDeProducto;



    public Producto(String NombreDeProducto, float PrecioDeProducto) {
        this.NombreDeProducto = NombreDeProducto;
        this.PrecioDeProducto = PrecioDeProducto;
    }

    public Producto(int i) {
    }

    public String getNombreDeProducto() {
        return NombreDeProducto;
    }

    public void setNombreDeProducto() {
        this.NombreDeProducto = NombreDeProducto;
    }

    public float getPrecioDeProducto() {
        return PrecioDeProducto;
    }

    public void setPrecioDeProducto(float PrecioDeProducto) {
        this.PrecioDeProducto = PrecioDeProducto;
    }

    @Override
    public String toString() {
        return String.format("%s %f",NombreDeProducto,PrecioDeProducto);
    }
}
