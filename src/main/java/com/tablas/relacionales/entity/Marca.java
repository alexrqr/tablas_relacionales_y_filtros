package com.tablas.relacionales.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "marcas")
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Integer idMarca;

    @Column(name = "nombre_marca", nullable = false, unique = true, length = 45)
    private String nombreMarca;

    //Relacionando Marca -> Categoria
    @OneToMany
    @JoinColumn(name = "marca_id")
    private List<Categoria> categorias = new ArrayList<>();

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }


    //constructor

    public Marca() {
    }

    public Marca(Integer idMarca, String nombreMarca, List<Categoria> categorias) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.categorias = categorias;
    }

    public Marca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Marca(String nombreMarca, List<Categoria> categorias) {
        this.nombreMarca = nombreMarca;
        this.categorias = categorias;
    }
}
