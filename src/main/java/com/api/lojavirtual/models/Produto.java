package com.api.lojavirtual.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	private String tipoUnidade;
	
	private String nome;
	
	@Column(columnDefinition = "text", length = 2000)
	private String descricao;
	
	/* Nota Item nota Produto ASSOCIAR*/
	
	
	private Double peso;
	
	private Double largura;
	
	private Double altura;
	
	private Double profundidade;
	
	private BigDecimal valorVenda;
	
	private Integer qtdEstoque;
	
	
	
	
	

}
