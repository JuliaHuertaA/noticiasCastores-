package com.noticias.noticias.servicios;

import com.noticias.noticias.modelos.*;
import com.noticias.noticias.repositorios.ComentariosRepository;
import com.noticias.noticias.repositorios.NoticiasRepository;
import com.noticias.noticias.repositorios.PerfilRepository;
import com.noticias.noticias.repositorios.RespuestaComentariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class RespuestaComentariosService {
    @Autowired
    RespuestaComentariosRepository respuestaComentariosRepository;
    @Autowired
    ComentariosRepository comentariosRepository;
    @Autowired
    PerfilRepository perfilRepository;

    public RespuestaComentariosModel agregarRepuesta(AgregarRespuesta respuesta){
        RespuestaComentariosModel respuestaComentariosModel = new RespuestaComentariosModel();
        respuestaComentariosModel.setRespuesta(respuesta.getRespuesta());
        respuestaComentariosModel.setFecha(new Date());
        Optional<PerfilModel> perfilModel = perfilRepository.findById(respuesta.getIdPerfil());
        Optional<ComentariosModel> comentariosModel = comentariosRepository.findById(respuesta.getIdComentario());

        if (perfilModel.isPresent()){
            respuestaComentariosModel.setPerfil(perfilModel.get());
        }
        if(comentariosModel.isPresent()){
            respuestaComentariosModel.setComentario(comentariosModel.get());
        }
        return respuestaComentariosRepository.save(respuestaComentariosModel);
    }

    public ArrayList<RespuestaComentariosModel> obtenerRespuestas(Integer id){
        Optional<ComentariosModel> comentariosModel = comentariosRepository.findById(id);
        if (comentariosModel.isPresent()){
            return respuestaComentariosRepository.findAllByComentario(comentariosModel.get());
        }else{
            return new ArrayList<>();
        }
    }

    public RespuestaComentariosModel editarRespuesta(ActualizarRespuesta datos){
        Optional<RespuestaComentariosModel> respuestaComentariosModel = respuestaComentariosRepository.findById(datos.getId());
        if(respuestaComentariosModel.isPresent()){
            respuestaComentariosModel.get().setRespuesta(datos.getRespuesta());
            respuestaComentariosRepository.save(respuestaComentariosModel.get());
        }
        return respuestaComentariosModel.get();
    }

    public Boolean eliminarRespuesta(Integer id){
        try{
            respuestaComentariosRepository.deleteById(id);
            return !(respuestaComentariosRepository.findById(id).isPresent());
        }catch (Exception e){
            return false;
        }
    }
}
