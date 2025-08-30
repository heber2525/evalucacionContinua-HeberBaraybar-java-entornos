package com.heberbaraybar.modelo;

public class Ropa {
    private String producto;
    private int referencia;
    private String color;
    private String talla;
    private double precio;

    public Ropa(String producto,int referencia,  String color,String talla, double precio){
        this.producto = producto;
        this.referencia = referencia;
        this.color = color;
        this.talla = talla;
        this.precio = precio;
    }


    public String getProducto(){return producto;}
    public int getReferencia(){return referencia;}
    public String getColor(){ return color; }
    public  String getTalla(){ return talla;}
    public double getPrecio(){ return precio;}


}


