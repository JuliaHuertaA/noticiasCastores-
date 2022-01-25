package com.noticias.noticias.controladores;

import com.noticias.noticias.modelos.ActualizarNoticia;
import com.noticias.noticias.modelos.NoticiasModel;
import com.noticias.noticias.modelos.PerfilModel;
import com.noticias.noticias.modelos.agregarNoticia;
import com.noticias.noticias.servicios.NoticiasService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/noticias")
public class NoticiasController {
    @Autowired
    NoticiasService noticiasService;

    @GetMapping()
    public ArrayList<NoticiasModel> mostrarNoticias(){
        return noticiasService.mostrarNoticias();
    }

    @PostMapping("/agregarNoticia")
    public NoticiasModel agregarNoticia(@RequestBody agregarNoticia noticia){
        return this.noticiasService.agregarNoticia(noticia);
    }

    @PostMapping("/editarNoticia")
    public NoticiasModel editarNoticia(@RequestBody ActualizarNoticia datos){
        return this.noticiasService.editarNoticia(datos);
    }

    @GetMapping( "/eliminarNoticia")
    public Boolean eliminarNotcia(@RequestParam("id") Integer id){
        return this.noticiasService.eliminarNoticia(id);
    }

}
