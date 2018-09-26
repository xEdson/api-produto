package com.meusprojetos.apiproduto.service;

import com.meusprojetos.apiproduto.models.Categoria;
import com.meusprojetos.apiproduto.repository.RepositoryCategoria;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaService {

  private final RepositoryCategoria repositorioCategoria;

  @Autowired
  CategoriaService(RepositoryCategoria repositorioCategoria){
    this.repositorioCategoria=repositorioCategoria;

  }
  public Categoria salvarCategoria(Categoria categoria) {
    categoria.setId(UUID.randomUUID().toString());
    return this.repositorioCategoria.save(categoria);
  }

  public Optional<Categoria> buscaUnitaria(String id) {

    return this.repositorioCategoria.findById(id);

  }

  public List<Categoria> buscaAll(){

    return this.repositorioCategoria.findAll();
  }

  public void delete(String id) {
    this.repositorioCategoria.deleteById(id);
  }

}
