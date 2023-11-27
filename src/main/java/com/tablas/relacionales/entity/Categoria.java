package com.tablas.relacionales.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "nombre",nullable = false, length = 45, unique = true)
    private String nombre;

    //Relacionando a la Entidad Marca
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    //get y sett

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }


    //constructor
    public Categoria() {
    }

    public Categoria(Integer idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    public Categoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    public Categoria(Integer idCategoria, String nombre, Marca marca) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.marca = marca;
    }

    public Categoria(String nombre, Marca marca) {
        this.nombre = nombre;
        this.marca = marca;
    }
    //para mostrar su dato

    @Override
    public String toString() {
        return nombre;
    }
}

