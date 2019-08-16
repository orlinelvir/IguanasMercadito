package edu.ujcv.progra2.company;

public class Cliente {
    private String NombreDeCliente;
    private float NumeroDeCuenta;



    public Cliente(String NombreDeCliente, float NumeroDeCuenta) {
        this.NombreDeCliente = NombreDeCliente;
        this.NumeroDeCuenta = NumeroDeCuenta;
    }


    public String getNombreDeCliente() {
        return NombreDeCliente;
    }

    public void setNombreDeCliente() {
        this.NumeroDeCuenta = NumeroDeCuenta;
    }

    public float getNumeroDeCuenta() {
        return NumeroDeCuenta;
    }

    public void setNumeroDeCuenta(float NumeroDeCuenta) {
        this.NumeroDeCuenta = NumeroDeCuenta;
    }

    @Override
    public String toString() {
        return String.format("%s %f",NombreDeCliente,NumeroDeCuenta);
    }
}

