package com.meusprojetos.apiproduto.service;

import com.meusprojetos.apiproduto.models.Produto;
import com.meusprojetos.apiproduto.repository.RepositoryProduto;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

  private final RepositoryProduto repositorioProduto;
  @Autowired
  ProdutoService(RepositoryProduto repositorioProduto){
    this.repositorioProduto=repositorioProduto;

  }
  public Produto salvarProduto(Produto produto) {

    produto.setId(UUID.randomUUID().toString());
    return this.repositorioProduto.save(produto);
  }

  public List<Produto> buscaAll(){

    return this.repositorioProduto.findAll();

  }
  public Optional<Produto> buscarUnitaria(String id){
    return this.repositorioProduto.findById(id);
  }
  public void deletarUnitario(String id) {

    this.repositorioProduto.deleteById(id);
  }

}
