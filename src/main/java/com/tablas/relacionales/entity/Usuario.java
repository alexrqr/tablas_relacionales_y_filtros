package com.tablas.relacionales.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer idUsuario;

    @Column(name = "email", length = 45, unique = true)
    private String email;

    @Column(name = "password", length = 45, nullable = false)
    private String password;

    //Relacion muchoas a muchos (usuarios <-> roles
    @ManyToMany
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private Set<Rol>roles = new HashSet<>();

    //get y set

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    //constructors
    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Usuario(Integer idUsuario, String email, String password, Set<Rol> roles) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    //toString

    @Override
    public String toString() {
        return "Usuario[" +
                "email='" + email +
                ']';
    }


    //Metodo para agregar y eliminar rol
    public void añadirRol(Rol rol) {
        this.roles.add(rol);
    }

    public void eliminarRol(Rol rol) {
        this.roles.remove(rol);
    }
}
