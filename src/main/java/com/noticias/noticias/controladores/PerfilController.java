package com.noticias.noticias.controladores;

import com.noticias.noticias.modelos.PerfilModel;
import com.noticias.noticias.modelos.verificarLogin;
import com.noticias.noticias.servicios.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class PerfilController {
    @Autowired
    PerfilService perfilService;

    @GetMapping()
    public ArrayList<PerfilModel> login(){
        return perfilService.obtenerPerfiles();
    }

    @PostMapping("/verificar")
    public Optional<PerfilModel> verificarLogin(@RequestBody verificarLogin datos){
        return perfilService.verficarLogin(datos.getId(),datos.getContrasena());
    }
}
