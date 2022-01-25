package com.noticias.noticias.modelos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="perfil")

public class PerfilModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPerfil", unique = true, nullable = false)
    private Integer id;
    @ManyToOne(fetch=FetchType.LAZY, targetEntity= PersonalModel.class, optional = true)
    @JoinColumn(name = "idPersonal", nullable = true)
    private PersonalModel personal;
    @ManyToOne(fetch=FetchType.LAZY, targetEntity= UsuarioModel.class, optional = true)
    @JoinColumn(name = "idUsuario", nullable = true)
    private UsuarioModel usuario;
    @Column(name = "esExterno")
    private Boolean esExterno;
    @Column(name = "contrasena")
    private String contrasena;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PersonalModel getIdPersonal() {
        return personal;
    }

    public void setIdPersonal(PersonalModel personal) {
        this.personal = personal;
    }

    public UsuarioModel getIdUsuario() {
        return usuario;
    }

    public void setIdUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public Boolean getEsExterno() {
        return esExterno;
    }

    public void setEsExterno(Boolean esExterno) {
        this.esExterno = esExterno;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
