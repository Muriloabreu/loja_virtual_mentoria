package com.api.lojavirtual.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vd_cp_loja_virt")
@SequenceGenerator(name = "seq_vd_cp_loja_virt", sequenceName = "seq_vd_cp_loja_virt", allocationSize = 1, initialValue = 1	)
public class VendaCompraLojaVirtual implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vd_cp_loja_virt")
	private Long id;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn(name = "pessoa_id", nullable = false, 
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "paessoa_fk") )
	private Pessoa pessoa;
	
	@ManyToOne()
	@JoinColumn(name = "endereco_entrega_id", nullable = false, 
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_entrega_fk") )
	private Endereco enderecoEntrega;
	
	@ManyToOne()
	@JoinColumn(name = "endereco_cobranca_id", nullable = false, 
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "endereco_cobranca_fk") )
	private Endereco enderecoCobranca;
	
	private BigDecimal valorTotal;
	
	private BigDecimal valorDesconto;
	
	@ManyToOne()
	@JoinColumn(name = "forma_pagamento_id", nullable = false, 
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "forma_pagamento__fk") )
	private FormaPagamento formaPagamento;
	
	
	@OneToOne()
	@JoinColumn(name = "nota_fiscal_venda_id", nullable = false, 
	foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "nota_fiscal_venda__fk") )
	private NotaFiscalVenda notaFiscalVenda;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
