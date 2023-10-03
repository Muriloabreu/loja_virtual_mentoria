package com.api.lojavirtual.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "categoria_produto")
@SequenceGenerator(name = "seq_categoria_produto", sequenceName = "seq_categoria_produto", allocationSize = 1, initialValue = 1)
public class CategoriaProduto implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	@Column(name = "nome_desc", nullable = false)
	private String nome_desc;
	
	/* Constructor */

	public CategoriaProduto() {
	}

	public CategoriaProduto(Long id, String nome_desc) {
		this.id = id;
		this.nome_desc = nome_desc;
	}
	
	/* Accessor Methods */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome_desc() {
		return nome_desc;
	}

	public void setNome_desc(String nome_desc) {
		this.nome_desc = nome_desc;
	}

	@Override
	public String toString() {
		return "Categoria_Produto [id=" + id + ", nome_desc=" + nome_desc + "]";
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
		CategoriaProduto other = (CategoriaProduto) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
	
	
	

}
