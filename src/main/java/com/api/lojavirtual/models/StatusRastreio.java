package com.api.lojavirtual.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "status_rastreio")
@SequenceGenerator(name = "seq_status_rastreio", sequenceName = "seq_status_rastreio", allocationSize = 1, initialValue = 1	)
public class StatusRastreio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_status_rastreio")
	private Long id;
	
	private String centroDistribuicao;
	
	private String cidade;
	
	private String estado;
	
	private String status;
	
	/* Constructor */
	
	
	public StatusRastreio() {
		
	}


	public StatusRastreio(Long id, String centroDistribuicao, String cidade, String estado, String status) {
		this.id = id;
		this.centroDistribuicao = centroDistribuicao;
		this.cidade = cidade;
		this.estado = estado;
		this.status = status;
	}

	
	/* Accessor Methods */

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCentroDistribuicao() {
		return centroDistribuicao;
	}


	public void setCentroDistribuicao(String centroDistribuicao) {
		this.centroDistribuicao = centroDistribuicao;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
