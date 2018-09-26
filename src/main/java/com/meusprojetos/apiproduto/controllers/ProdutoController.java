package com.meusprojetos.apiproduto.controllers;

import com.meusprojetos.apiproduto.models.Produto;
import com.meusprojetos.apiproduto.service.ProdutoService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoService produtos; //Service de produtos

  @GetMapping("/{id}")
  public Optional<Produto> buscar(@PathVariable String id) {
    return produtos.buscarUnitaria(id);
  }
  @GetMapping
  public List<Produto> pesquisar() {
    return produtos.buscaAll();
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public ResponseEntity<Produto> salvar(@RequestBody @Valid Produto produto) {
    Produto prod = produtos.salvarProduto(produto);
    return new ResponseEntity<>(prod, HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void deletar(@PathVariable String id) {
    produtos.deletarUnitario(id);
  }

}
