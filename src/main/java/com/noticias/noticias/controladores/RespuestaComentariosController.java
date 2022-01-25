package com.noticias.noticias.controladores;


import com.noticias.noticias.modelos.*;
import com.noticias.noticias.servicios.RespuestaComentariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/respuestas")

public class RespuestaComentariosController {
    @Autowired
    RespuestaComentariosService respuestaComentariosService;

    @PostMapping("/agregarRespuesta")
    public RespuestaComentariosModel agregarRespuesta(@RequestBody AgregarRespuesta respuesta){
        return this.respuestaComentariosService.agregarRepuesta(respuesta);
    }

    @GetMapping("/obtenerRespuestas")
    public ArrayList<RespuestaComentariosModel> obtenerRespuestas(@RequestParam("id") Integer id){
        return this.respuestaComentariosService.obtenerRespuestas(id);
    }

    @PostMapping("/editarRespuesta")
    public RespuestaComentariosModel editarRespuesta(@RequestBody ActualizarRespuesta datos){
        return this.respuestaComentariosService.editarRespuesta(datos);
    }

    @GetMapping( "/eliminarRespuesta")
    public Boolean eliminarRespuesta(@RequestParam("id") Integer id){
        return this.respuestaComentariosService.eliminarRespuesta(id);
    }

}
