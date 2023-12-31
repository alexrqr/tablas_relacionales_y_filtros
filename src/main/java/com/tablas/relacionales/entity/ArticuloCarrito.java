package com.tablas.relacionales.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "articulo_carrito")
public class ArticuloCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artCarrito")
    private Integer id;

    @Column(name = "cantidad")
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    //Get y set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //Constructors

    public ArticuloCarrito(Integer id, int cantidad, Producto producto, Usuario usuario) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.usuario = usuario;
    }

    public ArticuloCarrito() {
    }

    public ArticuloCarrito(int cantidad, Producto producto, Usuario usuario) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.usuario = usuario;
    }
    //toString

    @Override
    public String toString() {
        return "ArticuloCarrito{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                ", usuario=" + usuario +
                '}';
    }
}
