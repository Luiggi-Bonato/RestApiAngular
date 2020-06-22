package com.luiggibonato.dev.restAPI.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiggibonato.dev.restAPI.web.domain.Produto;
import com.luiggibonato.dev.restAPI.web.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public Produto getProdutoById(Long id) {
		return produtoRepository.findById(id).get();
	}
	
	public List<Produto> getProdutoByNome(String nome) {
		return produtoRepository.findProdutoByNome(nome);
	}
	
	public List<Produto> getProdutoByDescricao(String descricao) {
		return produtoRepository.findProdutoByDescricao(descricao);
	}
	
	public List<Produto> getProdutoByPreco(Double preco) {
		return produtoRepository.findProdutoByPreco(preco);
	}
	
	public void deleteById(Long id) {
		produtoRepository.deleteById(id);
	}
	
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}
	
	public Produto update(Produto produto) {
		if(produto!=null) {
			return produtoRepository.save(produto);
		}
		throw new RuntimeException("ID precisar ser informado");
	}

}
