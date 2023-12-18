package com.tablas.relacionales.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tecnologias")
public class Tecnologia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTecnologia;
    @Column(name = "nombre", nullable = false, length = 60, unique = true)
    private String nombre;
    @Column(name = "marca", nullable = false, length = 60)
    private String marca;
    @Column(name = "hechoEn", nullable = false, length = 20)
    private String hechoEn;
    @Column(name = "precio", nullable = false)
    private float precio;

    //get y set

    public Integer getIdTecnologia() {
        return idTecnologia;
    }

    public void setIdTecnologia(Integer idTecnologia) {
        this.idTecnologia = idTecnologia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getHechoEn() {
        return hechoEn;
    }

    public void setHechoEn(String hechoEn) {
        this.hechoEn = hechoEn;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    //constructor

    public Tecnologia() {
    }

    public Tecnologia(Integer idTecnologia, String nombre, String marca, String hechoEn, float precio) {
        this.idTecnologia = idTecnologia;
        this.nombre = nombre;
        this.marca = marca;
        this.hechoEn = hechoEn;
        this.precio = precio;
    }



}
