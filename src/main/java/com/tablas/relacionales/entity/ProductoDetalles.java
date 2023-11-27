package com.tablas.relacionales.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "producto_detalles")
public class ProductoDetalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProdDet")
    private Integer id;

    @Column(name = "nombre_producto", length = 45, nullable = false)
    private String nombre;

    @Column(name = "valor", length = 45, nullable = false)
    private String valor;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    //get y set


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    //constructors

    public ProductoDetalles(Integer id, String nombre, String valor, Producto producto) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.producto = producto;
    }

    public ProductoDetalles(String nombre, String valor, Producto producto) {
        this.nombre = nombre;
        this.valor = valor;
        this.producto = producto;
    }

    public ProductoDetalles() {
    }

    //toString

    @Override
    public String toString() {
        return nombre + " - " + valor;
    }


}
