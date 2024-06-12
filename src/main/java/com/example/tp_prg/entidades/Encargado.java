package com.example.tp_prg.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "encargado")
public class Encargado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_encargado")
    private Long idEncargado;

    @Column(name = "enc_nom")
    private String nombre;

    @Column(name = "enc_ape")
    private String apellido;

    @Column(name = "enc_cedula")
    private String cedula;

    @Column(name = "enc_direccion")
    private String direccion;

    @Column(name = "enc_email")
    private String email;

    @Column(name = "enc_relacion")
    private String relacion;

    @Column(name = "enc_num_cont_uno")
    private Integer numeroContactoUno;

    @Column(name = "enc_num_cont_dos")
    private Integer numeroContactoDos;


    @Column(name = "enc_nom_cont_dos")
    private String nombreContactoDos;

    // Getters y setters
    public Long getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(Long idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public Integer getNumeroContactoUno() {
        return numeroContactoUno;
    }

    public void setNumeroContactoUno(Integer numeroContactoUno) {
        this.numeroContactoUno = numeroContactoUno;
    }

    public Integer getNumeroContactoDos() {
        return numeroContactoDos;
    }

    public void setNumeroContactoDos(Integer numeroContactoDos) {
        this.numeroContactoDos = numeroContactoDos;
    }


    public String getNombreContactoDos() {
        return nombreContactoDos;
    }

    public void setNombreContactoDos(String nombreContactoDos) {
        this.nombreContactoDos = nombreContactoDos;
    }
}
