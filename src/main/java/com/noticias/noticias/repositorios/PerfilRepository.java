package com.noticias.noticias.repositorios;

import com.noticias.noticias.modelos.PerfilModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends CrudRepository<PerfilModel, Integer> {
}
