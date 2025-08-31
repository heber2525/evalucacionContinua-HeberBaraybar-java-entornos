package com.heberbaraybar.modelo;

/**
 * Representa una prenda de ropa en el inventario.
 * Contiene información sobre el nombre, referencia, color, talla y precio.
 * @author Heber
 * @version 1.0
 */
public class Ropa {

    private String producto;
    private int referencia;
    private String color;
    private String talla;
    private double precio;

    /**
     * Crea una nueva prenda de ropa con los datos proporcionados.
     * @param producto nombre del producto
     * @param referencia número de referencia único
     * @param color color de la prenda
     * @param talla talla de la prenda
     * @param precio precio de la prenda
     */
    public Ropa(String producto, int referencia, String color, String talla, double precio){
        this.producto = producto;
        this.referencia = referencia;
        this.color = color;
        this.talla = talla;
        this.precio = precio;
    }

    /** @return el nombre del producto */
    public String getProducto(){ return producto; }

    /** @return la referencia única del producto */
    public int getReferencia(){ return referencia; }

    /** @return el color de la prenda */
    public String getColor(){ return color; }

    /** @return la talla de la prenda */
    public String getTalla(){ return talla; }

    /** @return el precio de la prenda */
    public double getPrecio(){ return precio; }

}
