package com.noticias.noticias.repositorios;

import com.noticias.noticias.modelos.NoticiasModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiasRepository extends CrudRepository<NoticiasModel,Integer> {
}
