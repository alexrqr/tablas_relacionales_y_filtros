package com.tablas.relacionales.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    @Column(name = "nombre", length = 128, nullable = false, unique = true)
    private String nombre;

    @Column(name = "precio")
    private float precio;

    //arregla detalles a un array
    //Many to One, relacion de muchoas a uno (producto -> categoria)
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    //relacionando tabla producto con productodetalles
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<ProductoDetalles> detalles = new ArrayList<>();

    //gett y sett

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public List<ProductoDetalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ProductoDetalles> detalles) {
        this.detalles = detalles;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    //constructor
    public Producto(Integer idProducto, String nombre, float precio, Categoria categoria, List<ProductoDetalles> detalles) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.detalles = detalles;
    }

    public Producto() {
    }

    public Producto(String nombre, float precio, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    //toString

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + "]";
    }

    public void añadirDetalles(String detallesNombre, String detallesValore) {
        this.detalles.add(new ProductoDetalles(detallesNombre, detallesValore,  this));
    }

    public void setDetalle(Integer id, String nombre, String valor) {
        this.detalles.add(new ProductoDetalles(id, nombre, valor, this));
    }
}
