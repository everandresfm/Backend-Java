package com.example.tp_prg.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cur")
    private Integer idCur;

    @Column(name = "cur_nivel")
    private String curNivel;

    @Column(name = "cur_ciclo")
    private String curCiclo;

    @Column(name = "curso")
    private String curso;

    @Column(name = "cur_turno")
    private String curTurno;

    @Column(name = "cur_matricula")
    private Integer curMatricula;

    @Column(name = "cur_año")
    private Integer curAño;

    @Column(name = "cur_cuota")
    private Integer curCuota;

    @Column(name = "cur_especi")
    private String curEspeci;

    // Getters y setters
    public Integer getIdCur() {
        return idCur;
    }

    public void setIdCur(Integer idCur) {
        this.idCur = idCur;
    }

    public String getCurNivel() {
        return curNivel;
    }

    public void setCurNivel(String curNivel) {
        this.curNivel = curNivel;
    }

    public String getCurCiclo() {
        return curCiclo;
    }

    public void setCurCiclo(String curCiclo) {
        this.curCiclo = curCiclo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCurTurno() {
        return curTurno;
    }

    public void setCurTurno(String curTurno) {
        this.curTurno = curTurno;
    }

    public Integer getCurMatricula() {
        return curMatricula;
    }

    public void setCurMatricula(Integer curMatricula) {
        this.curMatricula = curMatricula;
    }

    public Integer getCurAño() {
        return curAño;
    }

    public void setCurAño(Integer curAño) {
        this.curAño = curAño;
    }

    public Integer getCurCuota() {
        return curCuota;
    }

    public void setCurCuota(Integer curCuota) {
        this.curCuota = curCuota;
    }

    public String getCurEspeci() {
        return curEspeci;
    }

    public void setCurEspeci(String curEspeci) {
        this.curEspeci = curEspeci;
    }
}
