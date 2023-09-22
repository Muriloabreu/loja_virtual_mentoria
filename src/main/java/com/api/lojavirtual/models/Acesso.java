package com.api.lojavirtual.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "acesso")
@SequenceGenerator(name = "seq_marca_produto", sequenceName = "seq_marca_produto", allocationSize = 1, initialValue = 1	)
public class Acesso implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca_produto")
	private Long id;
	@Column(name = "nome_desc", nullable = false)
	private String nomeDesc;
	

	/* Constructor */
	
	public Acesso() {
		
	}
	public Acesso(Long id, String nomeDesc) {
		this.id = id;
		this.nomeDesc = nomeDesc;
	}
	
	/* Accessor Methods */
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeDesc() {
		return nomeDesc;
	}
	public void setNomeDesc(String nomeDesc) {
		this.nomeDesc = nomeDesc;
	}
	@Override
	public String toString() {
		return "Acesso [id=" + id + ", nomeDesc=" + nomeDesc + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acesso other = (Acesso) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	

}
