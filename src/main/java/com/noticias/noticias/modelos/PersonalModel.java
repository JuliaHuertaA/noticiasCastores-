package com.noticias.noticias.modelos;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="personal")

public class PersonalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersonal", unique = true, nullable = false)
    private Integer idPersonal;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apePaterno")
    private String apePaterno;
    @Column(name = "apeMaterno")
    private String apeMaterno;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fechaIngreso")
    private Date fechaIngreso;

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
