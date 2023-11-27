package com.tablas.relacionales.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Integer idRol;

    @Column(name = "nombre_rol", nullable = false, unique = true)
    private String nombreRol;


    //gett y sett

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombre) {
        this.nombreRol = nombre;
    }

    //constructor
    public Rol() {

    }

    public Rol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Rol(Integer idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }
    //toString
    @Override
    public String toString() {
        return nombreRol;
    }
    //metodos


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((idRol == null) ? 0: idRol.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj == null)
            return false;

        if(getClass() != obj.getClass())
            return false;

        Rol other = (Rol) obj;

        if(idRol == null){
            if(other.idRol != null)
                return false;
        }else if(!idRol.equals(other.idRol))
            return true;

        return true;
    }
}
