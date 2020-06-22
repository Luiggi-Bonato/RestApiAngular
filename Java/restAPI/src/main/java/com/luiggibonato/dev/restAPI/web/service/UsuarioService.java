package com.luiggibonato.dev.restAPI.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiggibonato.dev.restAPI.web.domain.Usuario;
import com.luiggibonato.dev.restAPI.web.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	public List<Usuario> getUsuarioByFirstName(String firstName) {
		return usuarioRepository.findUsuarioByFirstName(firstName);
	}
	
	public List<Usuario> getUsuarioByLastName(String lastName) {
		return usuarioRepository.findUsuarioByLastName(lastName);
	}
	
	public List<Usuario> getUsuarioByEmail(String email) {
		return usuarioRepository.findUsuarioByEmail(email);
	}
	
	public List<Usuario> getUsuarioByPhoneNumber(String phoneNumber) {
		return usuarioRepository.findUsuarioByPhoneNumber(phoneNumber);
	}
	
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	public Usuario update(Usuario usuario) {
		if(usuario!=null) {
			return usuarioRepository.save(usuario);
		}
		throw new RuntimeException("ID precisar ser informado");
	}

}
