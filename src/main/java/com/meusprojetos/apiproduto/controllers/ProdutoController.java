package com.meusprojetos.apiproduto.controllers;

import com.meusprojetos.apiproduto.models.Produto;
import com.meusprojetos.apiproduto.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoService produtos; //Service de produtos

  @ApiOperation(
      value="Pesquisar um novo produto",
      response=Produto.class,
      notes="Essa operação pesquisa um produto a partir do seu id.")
  @ApiResponses(value= {
      @ApiResponse(
          code=200,
          message="Retorna o Produto pesquisado",
          response=Produto.class
      ),
      @ApiResponse(
          code=404,
          message="Não foi encontrado o produto com o id referente")

  })
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseEntity<Produto> buscar(@PathVariable String id) {
    Optional<Produto> produto = produtos.buscarUnitaria(id);

    if (produto.isPresent()) {
      return ResponseEntity.status(HttpStatus.OK).body(produto.get());
    }else{
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
  }
  @RequestMapping(method = RequestMethod.GET)
  public List<Produto> pesquisar() {
    return produtos.buscaAll();
  }


  @ApiOperation(
      value="Cadastrar um novo produto",
      response=Produto.class,
      notes="Essa operação salva um novo registro com as informações de produto.")
  @ApiResponses(value= {
      @ApiResponse(
          code=201,
          message="Retorna um Produto com uma mensagem de sucesso",
          response=Produto.class
      ),
      @ApiResponse(
          code=500,
          message="Caso tenhamos algum erro vamos retornar um Produto com a Exception",
          response=Produto.class
      )

  })
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity <Produto> salvar(@RequestBody @Valid Produto produto) {
    Produto prod = produtos.salvarProduto(produto);
    return new ResponseEntity<>(prod, HttpStatus.CREATED);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletar(@PathVariable String id) {
    produtos.deletarUnitario(id);
  }

}
