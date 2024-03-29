package com.api.lojavirtual.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "imagem_produto")
@SequenceGenerator(name = "seq_imagem_produto", sequenceName = "seq_imagem_produto", allocationSize = 1, initialValue = 1	)
public class ImagemProduto implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_imagem_produto")
	private Long id;
	
	
	@Column(columnDefinition = "text", nullable = false)
	private String imagemOriginal;
	
	@Column(columnDefinition = "text", nullable = false)
	private String imagemMiniaura;
	
	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk") )
	private Produto produto;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "empresa_id", nullable = false, 
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_id_fk"))
	private Pessoa empresa;
	
	/* Constructor */
	
	public ImagemProduto() {
	}
	
	public ImagemProduto(Long id, String imagemOriginal, String imagemMiniaura, Produto produto, Pessoa empresa) {
		
		this.id = id;
		this.imagemOriginal = imagemOriginal;
		this.imagemMiniaura = imagemMiniaura;
		this.produto = produto;
		this.empresa = empresa;
	}



	/* Accessor Methods */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagemOriginal() {
		return imagemOriginal;
	}

	public void setImagemOriginal(String imagemOriginal) {
		this.imagemOriginal = imagemOriginal;
	}

	public String getImagemMiniaura() {
		return imagemMiniaura;
	}

	public void setImagemMiniaura(String imagemMiniaura) {
		this.imagemMiniaura = imagemMiniaura;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Pessoa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Pessoa empresa) {
		this.empresa = empresa;
	}


	@Override
	public String toString() {
		return "ImagemProduto [id=" + id + ", imagemOriginal=" + imagemOriginal + ", imagemMiniaura=" + imagemMiniaura
				+ ", produto=" + produto + ", empresa=" + empresa + "]";
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
		ImagemProduto other = (ImagemProduto) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
}
