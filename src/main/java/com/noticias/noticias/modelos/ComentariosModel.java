package com.noticias.noticias.modelos;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comentarios")

public class ComentariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComentario", unique = true, nullable = false)
    private Integer idComentario;
    @Column(name = "comentario")
    private String comentario;
    @ManyToOne(fetch=FetchType.LAZY, targetEntity= NoticiasModel.class, optional = true)
    @JoinColumn(name = "idNoticia", nullable = true)
    private NoticiasModel noticia;
    @ManyToOne(fetch=FetchType.LAZY, targetEntity= PerfilModel.class, optional = true)
    @JoinColumn(name = "idPerfil", nullable = true)
    private PerfilModel perfil;
    @Column(name = "fecha")
    private Date fecha;

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public NoticiasModel getNoticia() {
        return noticia;
    }

    public void setNoticia(NoticiasModel noticia) {
        this.noticia = noticia;
    }

    public PerfilModel getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilModel perfil) {
        this.perfil = perfil;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
