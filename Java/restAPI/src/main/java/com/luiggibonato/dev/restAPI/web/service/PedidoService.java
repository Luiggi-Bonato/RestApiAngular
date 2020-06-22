package com.luiggibonato.dev.restAPI.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiggibonato.dev.restAPI.web.domain.Pedido;
import com.luiggibonato.dev.restAPI.web.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido salvar(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public Pedido getPedidoById(Long id) {
		return pedidoRepository.findById(id).get();
	}
	
	public List<Pedido> getPedidoByComprador(Long comprador) {
		return pedidoRepository.findPedidoByComprador(comprador);
	}
	
	public List<Pedido> getPedidoByValor(Double valor) {
		return pedidoRepository.findPedidoByValor(valor);
	}
	
	public List<Pedido> getPedidoByStatus(int status) {
		return pedidoRepository.findPedidoByStatus(status);
	}
	
	public void deleteById(Long id) {
		pedidoRepository.deleteById(id);
	}
	
	public List<Pedido> listar(){
		return pedidoRepository.findAll();
	}
	
	public Pedido update(Pedido pedido) {
		if(pedido!=null) {
			return pedidoRepository.save(pedido);
		}
		throw new RuntimeException("ID precisar ser informado");
	}

}
