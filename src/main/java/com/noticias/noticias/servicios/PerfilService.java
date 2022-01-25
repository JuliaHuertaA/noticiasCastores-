package com.noticias.noticias.servicios;

import com.noticias.noticias.modelos.PerfilModel;
import com.noticias.noticias.repositorios.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import java.util.Optional;

@Service
public class PerfilService {
    @Autowired
    PerfilRepository perfilRepository;

    public ArrayList<PerfilModel> obtenerPerfiles(){
        return (ArrayList<PerfilModel>)perfilRepository.findAll();
    }

    public Optional<PerfilModel> verficarLogin(Integer idPerfil, String contrasena){
        Optional<PerfilModel> perfil = perfilRepository.findById(idPerfil);
        if(perfil.isPresent()){
             if (perfil.get().getContrasena().equals(contrasena)) {
                 return perfil;
             }
        }
        return perfil;
    }
}
