package com.noticias.noticias.servicios;

import com.noticias.noticias.modelos.ActualizarNoticia;
import com.noticias.noticias.modelos.NoticiasModel;
import com.noticias.noticias.modelos.PerfilModel;
import com.noticias.noticias.modelos.agregarNoticia;
import com.noticias.noticias.repositorios.NoticiasRepository;
import com.noticias.noticias.repositorios.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class NoticiasService {
    @Autowired
    NoticiasRepository noticiasRepository;
    @Autowired
    PerfilRepository perfilRepository;

    public ArrayList<NoticiasModel> mostrarNoticias(){
        return (ArrayList<NoticiasModel>) noticiasRepository.findAll();
    }

    public NoticiasModel agregarNoticia(agregarNoticia noticia){
        NoticiasModel noticiasModel = new NoticiasModel();
        noticiasModel.setEncabezado(noticia.getEncabezado());
        noticiasModel.setCuerpo(noticia.getCuerpo());
        noticiasModel.setFecha(new Date());
        Optional<PerfilModel> perfilModel = perfilRepository.findById(noticia.getPerfil());
        if (perfilModel.isPresent()){
            noticiasModel.setIdPerfil(perfilModel.get());
        }
        return noticiasRepository.save(noticiasModel) ;
    }

    public NoticiasModel editarNoticia(ActualizarNoticia datos){
        Optional<NoticiasModel> noticiasModel = noticiasRepository.findById(datos.getId());
        if(noticiasModel.isPresent()){
            noticiasModel.get().setEncabezado(datos.getEncabezado());
            noticiasModel.get().setCuerpo(datos.getCuerpo());
            noticiasRepository.save(noticiasModel.get());
        }
        return noticiasModel.get();
    }

    public Boolean eliminarNoticia(Integer id){
        try{
        noticiasRepository.deleteById(id);
        return !(noticiasRepository.findById(id).isPresent());
        }catch (Exception e){
            return false;
        }
    }
}
