package com.noticias.noticias.repositorios;

import com.noticias.noticias.modelos.ComentariosModel;
import com.noticias.noticias.modelos.NoticiasModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ComentariosRepository extends CrudRepository<ComentariosModel,Integer> {
    ArrayList<ComentariosModel> findAllByNoticia(NoticiasModel noticia);
}
