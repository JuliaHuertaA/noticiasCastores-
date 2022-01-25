package com.noticias.noticias.servicios;

import com.noticias.noticias.modelos.*;
import com.noticias.noticias.repositorios.ComentariosRepository;
import com.noticias.noticias.repositorios.NoticiasRepository;
import com.noticias.noticias.repositorios.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class ComentariosService {
    @Autowired
    ComentariosRepository comentariosRepository;
    @Autowired
    NoticiasRepository noticiasRepository;
    @Autowired
    PerfilRepository perfilRepository;

    public ComentariosModel agregarComentario(CrearComentario comentario){
        ComentariosModel comentariosModel = new ComentariosModel();
        comentariosModel.setComentario(comentario.getComentario());
        comentariosModel.setFecha(new Date());
        Optional<PerfilModel> perfilModel = perfilRepository.findById(comentario.getPerfil());
        Optional<NoticiasModel> noticiasModel = noticiasRepository.findById(comentario.getIdNoticia());

        if (perfilModel.isPresent()){
            comentariosModel.setPerfil(perfilModel.get());
        }
        if(noticiasModel.isPresent()){
            comentariosModel.setNoticia(noticiasModel.get());
        }
        return comentariosRepository.save(comentariosModel);
    }

    public ArrayList<ComentariosModel> obtenerComentarios(Integer id){
        Optional<NoticiasModel> noticiasModel = noticiasRepository.findById(id);
        if (noticiasModel.isPresent()){
            return comentariosRepository.findAllByNoticia(noticiasModel.get());
        }else{
            return new ArrayList<>();
        }
    }

    public ComentariosModel editarComentario(ActualizarComentario datos){
        Optional<ComentariosModel> comentariosModel = comentariosRepository.findById(datos.getId());
        if(comentariosModel.isPresent()){
            comentariosModel.get().setComentario(datos.getComentario());
            comentariosRepository.save(comentariosModel.get());
        }
        return comentariosModel.get();
    }


    public Boolean eliminarComentario(Integer id){
        try{
            comentariosRepository.deleteById(id);
            return !(comentariosRepository.findById(id).isPresent());
        }catch (Exception e){
            return false;
        }
    }
}
