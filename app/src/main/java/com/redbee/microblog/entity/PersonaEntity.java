package com.redbee.microblog.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "persona", schema = "microblog")
public class PersonaEntity {
    private int idpersona;
    private String nombre;
    private String apellidos;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idpersona", nullable = false)
    public int getIdPersona() {
        return idpersona;
    }

    public void setIdPersona(int idpersona) {
        this.idpersona = idpersona;
    }

    @Basic
    @Column(name = "nombre", length = 64)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellidos", length = 64)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }



}
