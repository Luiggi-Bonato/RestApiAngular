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

import com.luiggibonato.dev.restAPI.web.domain.Usuario;
import com.luiggibonato.dev.restAPI.web.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRest {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuario")
	public ResponseEntity<Usuario> salvar(@RequestBody @Valid Usuario usuario) {
		return ResponseEntity.ok(usuarioService.salvar(usuario));
	}
	
	@GetMapping("/usuario")
	public ResponseEntity<List<Usuario>> listar() {
		return ResponseEntity.ok(usuarioService.listar());
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> consultaPorId(@PathVariable Long id) {
		Usuario usuario = usuarioService.getUsuarioById(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
		Usuario existe = usuarioService.getUsuarioById(id);
		if (existe == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(usuario, existe, "id");
		existe = usuarioService.salvar(existe);
		return ResponseEntity.ok(existe);
	}
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Void> deletetar(@PathVariable Long id) {
		Usuario usuario = usuarioService.getUsuarioById(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		usuarioService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
