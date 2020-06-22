package com.luiggibonato.dev.restAPI.web.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luiggibonato.dev.restAPI.web.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	List<Pedido> findPedidoById(Long id);
	
	List<Pedido> findPedidoByComprador(Long comprador);
	
	List<Pedido> findPedidoByValor(Double valor);
	
	List<Pedido> findPedidoByStatus(int status);

}
