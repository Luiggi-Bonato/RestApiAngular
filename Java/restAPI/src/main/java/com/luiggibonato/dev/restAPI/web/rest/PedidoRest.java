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

import com.luiggibonato.dev.restAPI.web.domain.Pedido;
import com.luiggibonato.dev.restAPI.web.service.PedidoService;

@RestController
@RequestMapping("/api")
public class PedidoRest {
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping("/pedido")
	public ResponseEntity<Pedido> salvar(@RequestBody @Valid Pedido pedido) {
		return ResponseEntity.ok(pedidoService.salvar(pedido));
	}
	
	@GetMapping("/pedido")
	public ResponseEntity<List<Pedido>> listar() {
		return ResponseEntity.ok(pedidoService.listar());
	}
	
	@GetMapping("/pedido/{id}")
	public ResponseEntity<Pedido> consultaPorId(@PathVariable Long id) {
		Pedido pedido = pedidoService.getPedidoById(id);
		if (pedido == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pedido);
	}
	
	@PutMapping("/pedido/{id}")
	public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody @Valid Pedido pedido) {
		Pedido existe = pedidoService.getPedidoById(id);
		if (existe == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(pedido, existe, "id");
		existe = pedidoService.salvar(existe);
		return ResponseEntity.ok(existe);
	}
	
	@DeleteMapping("/pedido/{id}")
	public ResponseEntity<Void> deletetar(@PathVariable Long id) {
		Pedido pedido = pedidoService.getPedidoById(id);
		if (pedido == null) {
			return ResponseEntity.notFound().build();
		}
		pedidoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
