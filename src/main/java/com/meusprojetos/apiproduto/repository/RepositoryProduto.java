package com.meusprojetos.apiproduto.repository;

import com.meusprojetos.apiproduto.models.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduto extends JpaRepository<Produto, String> {

}
