package com.luiggibonato.dev.restAPI.web.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long comprador;
	
	private ArrayList<Long> produtos;
	
	private Double valor;
	
	private int status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getComprador() {
		return comprador;
	}

	public void setComprador(Long comprador) {
		this.comprador = comprador;
	}

	public ArrayList<Long> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Long> produtos) {
		this.produtos = produtos;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
