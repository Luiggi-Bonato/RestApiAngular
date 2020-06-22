package com.luiggibonato.dev.restAPI.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luiggibonato.dev.restAPI.web.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findUsuarioById(Long id);
	
	List<Usuario> findUsuarioByFirstName(String firstName);
	
	List<Usuario> findUsuarioByLastName(String lastName);
	
	List<Usuario> findUsuarioByEmail(String email);
	
	List<Usuario> findUsuarioByPhoneNumber(String phoneNumber);

}
