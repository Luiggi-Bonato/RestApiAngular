package com.luiggibonato.dev.restAPI.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luiggibonato.dev.restAPI.web.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findProdutoById(Long id);
	
	List<Produto> findProdutoByNome(String nome);
	
	List<Produto> findProdutoByDescricao(String descricao);
	
	List<Produto> findProdutoByPreco(Double preco);

}
