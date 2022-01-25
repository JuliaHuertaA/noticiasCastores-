package com.noticias.noticias.modelos;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="noticias")

public class NoticiasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNoticia", unique = true, nullable = false)
    private Integer idNoticia;
    @Column(name = "encabezado")
    private String encabezado;
    @Column(name = "cuerpo")
    private String cuerpo;
    @Column(name = "fecha")
    private Date fecha;
    @ManyToOne(fetch=FetchType.LAZY, targetEntity= PerfilModel.class, optional = true)
    @JoinColumn(name = "idPerfil", nullable = true)
    private PerfilModel perfil;

    public Integer getIdNoticia() {
        return idNoticia;
    }

    public void setIdNoticia(Integer idNoticia) {
        this.idNoticia = idNoticia;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public PerfilModel getIdPerfil() {
        return perfil;
    }

    public void setIdPerfil(PerfilModel perfil) {
        this.perfil = perfil;
    }
}
