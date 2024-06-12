package com.example.tp_prg.entidades;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Long idAlumno;

    @Column(name = "alum_nom")
    private String nombre;

    @Column(name = "alum_ape")
    private String apellido;

    @Column(name = "alum_num_cont_uno")
    private Integer numeroContactoUno;

    @Column(name = "alum_num_cont_dos")
    private Integer numeroContactoDos;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_nac")
    private Date fechaNacimiento;

    @Column(name = "alum_estado")
    private String estado;


    @Column(name = "alum_nom_cont_dos")
    private String nombreContactoDos;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "email")
    private String email;

    @Column(name = "direccion")
    private String direccion;

    // Getters y setters
    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

 

    public String getNombreContactoDos() {
        return nombreContactoDos;
    }

    public void setNombreContactoDos(String nombreContactoDos) {
        this.nombreContactoDos = nombreContactoDos;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
