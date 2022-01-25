package com.noticias.noticias.controladores;

import com.noticias.noticias.modelos.*;
import com.noticias.noticias.servicios.ComentariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;

@RestController
@RequestMapping("/comentarios")
public class ComentariosController {

    @Autowired
    ComentariosService comentariosService;

    @PostMapping("/agregarComentario")
    public ComentariosModel agregarComentario(@RequestBody CrearComentario comentario){
        return this.comentariosService.agregarComentario(comentario);
    }

    @GetMapping("/obtenerComentarios")
    public ArrayList<ComentariosModel> obtenerComentarios(@RequestParam("id") Integer id){
        return this.comentariosService.obtenerComentarios(id);
    }

    @PostMapping("/editarComentario")
    public ComentariosModel editarComentario(@RequestBody ActualizarComentario datos){
        return this.comentariosService.editarComentario(datos);
    }

    @GetMapping( "/eliminarComentario")
    public Boolean eliminarComentario(@RequestParam("id") Integer id){
        return this.comentariosService.eliminarComentario(id);
    }

}
