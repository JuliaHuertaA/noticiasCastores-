package com.noticias.noticias.repositorios;

import com.noticias.noticias.modelos.ComentariosModel;
import com.noticias.noticias.modelos.RespuestaComentariosModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RespuestaComentariosRepository extends CrudRepository<RespuestaComentariosModel,Integer> {
    ArrayList<RespuestaComentariosModel> findAllByComentario(ComentariosModel comentario);
}
