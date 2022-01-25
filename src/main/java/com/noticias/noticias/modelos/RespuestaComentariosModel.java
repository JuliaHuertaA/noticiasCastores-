package com.noticias.noticias.modelos;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="respuestacomentarios")

public class RespuestaComentariosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRespuesta", unique = true, nullable = false)
    private Integer idRespuesta;

    @Column(name = "repuesta")
    private String respuesta;

    @ManyToOne(fetch=FetchType.LAZY, targetEntity= ComentariosModel.class, optional = true)
    @JoinColumn(name = "idComentario", nullable = true)
    private ComentariosModel comentario;

    @ManyToOne(fetch=FetchType.LAZY, targetEntity= PerfilModel.class, optional = true)
    @JoinColumn(name = "idPerfil", nullable = true)
    private PerfilModel perfil;

    @Column(name = "fecha")
    private Date fecha;

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public ComentariosModel getComentario() {
        return comentario;
    }

    public void setComentario(ComentariosModel comentario) {
        this.comentario = comentario;
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

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
