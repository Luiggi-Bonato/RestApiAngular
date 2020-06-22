package com.luiggibonato.dev.restAPI.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiggibonato.dev.restAPI.web.domain.Produto;
import com.luiggibonato.dev.restAPI.web.service.ProdutoService;

@RestController
@RequestMapping("/api")
public class ProdutoRest {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/produto")
	public ResponseEntity<Produto> salvar(@RequestBody @Valid Produto produto) {
		return ResponseEntity.ok(produtoService.salvar(produto));
	}
	
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> listar() {
		return ResponseEntity.ok(produtoService.listar());
	}
	
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> consultaPorId(@PathVariable Long id) {
		Produto produto = produtoService.getProdutoById(id);
		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produto);
	}
	
	@PutMapping("/produto/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody @Valid Produto produto) {
		Produto existe = produtoService.getProdutoById(id);
		if (existe == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(produto, existe, "id");
		existe = produtoService.salvar(existe);
		return ResponseEntity.ok(existe);
	}
	
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<Void> deletetar(@PathVariable Long id) {
		Produto produto = produtoService.getProdutoById(id);
		if (produto == null) {
			return ResponseEntity.notFound().build();
		}
		produtoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
