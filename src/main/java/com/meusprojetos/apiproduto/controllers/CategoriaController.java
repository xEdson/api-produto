package com.meusprojetos.apiproduto.controllers;

import com.meusprojetos.apiproduto.models.Categoria;
import com.meusprojetos.apiproduto.service.CategoriaService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CategoriaController {



  @Autowired
  private CategoriaService categorias;// <<< Repositório de categorias.

  @GetMapping("/{id}")
  public Optional<Categoria> buscar(@PathVariable String id) {
    return categorias.buscaUnitaria(id);
  }

  @GetMapping
  public List<Categoria> pesquisar() {
    return categorias.buscaAll();
  }


  @PostMapping
  public ResponseEntity<Categoria> salvar(@RequestBody @Valid Categoria categoria) {
    Categoria cat = categorias.salvarCategoria(categoria);
    return new ResponseEntity<>(cat, HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void deletar(@PathVariable String id) {
    categorias.delete(id);
  }

}
