package com.meusprojetos.apiproduto.repository;

import com.meusprojetos.apiproduto.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCategoria extends JpaRepository<Categoria, String> {

}
