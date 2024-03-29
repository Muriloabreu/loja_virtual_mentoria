package com.api.lojavirtual.models;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
	private Long id;
	@Column(nullable = false)
	private String tipoUnidade;
	@Column(nullable = false)
	private String nome;
	
	@Column(columnDefinition = "text", length = 2000, nullable = false)
	private String descricao;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "empresa_id", nullable = false, 
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "empresa_id_fk"))
	private Pessoa empresa;
	
	/* Nota Item nota Produto ASSOCIAR*/
	
	@Column(nullable = false)
	private Double peso;
	@Column(nullable = false)
	private Double largura;
	@Column(nullable = false)
	private Double altura;
	@Column(nullable = false)
	private Double profundidade;
	@Column(nullable = false)
	private BigDecimal valorVenda = BigDecimal.ZERO;
	@Column(nullable = false)
	private Integer qtdEstoque = 0;
	
	private Integer qtdAlertaEstoque = 0;
	
	private String linkYoutube;
	
	private Boolean alertaQtdEstoque = Boolean.FALSE;
	@Column(nullable = false)
	private Boolean ativo = Boolean.TRUE;
	
	private Integer qtdClique = 0;
	
	
	/* Constructor */
	
	public Produto() {
		
	}

	

	public Produto(Long id, String tipoUnidade, String nome, String descricao, Pessoa empresa, Double peso,
			Double largura, Double altura, Double profundidade, BigDecimal valorVenda, Integer qtdEstoque,
			Integer qtdAlertaEstoque, String linkYoutube, Boolean alertaQtdEstoque, Boolean ativo, Integer qtdClique) {
		
		this.id = id;
		this.tipoUnidade = tipoUnidade;
		this.nome = nome;
		this.descricao = descricao;
		this.empresa = empresa;
		this.peso = peso;
		this.largura = largura;
		this.altura = altura;
		this.profundidade = profundidade;
		this.valorVenda = valorVenda;
		this.qtdEstoque = qtdEstoque;
		this.qtdAlertaEstoque = qtdAlertaEstoque;
		this.linkYoutube = linkYoutube;
		this.alertaQtdEstoque = alertaQtdEstoque;
		this.ativo = ativo;
		this.qtdClique = qtdClique;
	}



	/* Accessor Methods */

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTipoUnidade() {
		return tipoUnidade;
	}


	public void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getPeso() {
		return peso;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public Double getLargura() {
		return largura;
	}


	public void setLargura(Double largura) {
		this.largura = largura;
	}


	public Double getAltura() {
		return altura;
	}


	public void setAltura(Double altura) {
		this.altura = altura;
	}


	public Double getProfundidade() {
		return profundidade;
	}


	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}


	public BigDecimal getValorVenda() {
		return valorVenda;
	}


	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}


	public Integer getQtdEstoque() {
		return qtdEstoque;
	}


	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}


	public Integer getQtdAlertaEstoque() {
		return qtdAlertaEstoque;
	}


	public void setQtdAlertaEstoque(Integer qtdAlertaEstoque) {
		this.qtdAlertaEstoque = qtdAlertaEstoque;
	}


	public String getLinkYoutube() {
		return linkYoutube;
	}


	public void setLinkYoutube(String linkYoutube) {
		this.linkYoutube = linkYoutube;
	}


	public Boolean getAlertaQtdEstoque() {
		return alertaQtdEstoque;
	}


	public void setAlertaQtdEstoque(Boolean alertaQtdEstoque) {
		this.alertaQtdEstoque = alertaQtdEstoque;
	}


	public Integer getQtdClique() {
		return qtdClique;
	}


	public void setQtdClique(Integer qtdClique) {
		this.qtdClique = qtdClique;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}	
	public Pessoa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Pessoa empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", tipoUnidade=" + tipoUnidade + ", nome=" + nome + ", descricao=" + descricao
				+ ", empresa=" + empresa + ", peso=" + peso + ", largura=" + largura + ", altura=" + altura
				+ ", profundidade=" + profundidade + ", valorVenda=" + valorVenda + ", qtdEstoque=" + qtdEstoque
				+ ", qtdAlertaEstoque=" + qtdAlertaEstoque + ", linkYoutube=" + linkYoutube + ", alertaQtdEstoque="
				+ alertaQtdEstoque + ", ativo=" + ativo + ", qtdClique=" + qtdClique + "]";
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	

}
