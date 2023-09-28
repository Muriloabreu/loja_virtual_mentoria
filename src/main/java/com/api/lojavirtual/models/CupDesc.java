package com.api.lojavirtual.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cup_desc")
@SequenceGenerator(name = "seq_cup_desc", sequenceName = "seq_cup_desc", allocationSize = 1, initialValue = 1)
public class CupDesc implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cup_desc")
	private Long id;
	
	private String codDesc;
	
	private BigDecimal valorRealDesc;
	
	private BigDecimal valorPorcentDesc;
	
	@Temporal(TemporalType.DATE)
	private Date dataValidadeCupom;
	
	
	/* Constructor */
	
	public CupDesc() {
		
	}

	public CupDesc(Long id, String codDesc, BigDecimal valorRealDesc, BigDecimal valorPorcentDesc,
			Date dataValidadeCupom) {
		this.id = id;
		this.codDesc = codDesc;
		this.valorRealDesc = valorRealDesc;
		this.valorPorcentDesc = valorPorcentDesc;
		this.dataValidadeCupom = dataValidadeCupom;
	}
	
	/* Accessor Methods */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodDesc() {
		return codDesc;
	}

	public void setCodDesc(String codDesc) {
		this.codDesc = codDesc;
	}

	public BigDecimal getValorRealDesc() {
		return valorRealDesc;
	}

	public void setValorRealDesc(BigDecimal valorRealDesc) {
		this.valorRealDesc = valorRealDesc;
	}

	public BigDecimal getValorPorcentDesc() {
		return valorPorcentDesc;
	}

	public void setValorPorcentDesc(BigDecimal valorPorcentDesc) {
		this.valorPorcentDesc = valorPorcentDesc;
	}

	public Date getDataValidadeCupom() {
		return dataValidadeCupom;
	}

	public void setDataValidadeCupom(Date dataValidadeCupom) {
		this.dataValidadeCupom = dataValidadeCupom;
	}

	@Override
	public String toString() {
		return "CupDesc [id=" + id + ", codDesc=" + codDesc + ", valorRealDesc=" + valorRealDesc + ", valorPorcentDesc="
				+ valorPorcentDesc + ", dataValidadeCupom=" + dataValidadeCupom + "]";
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
		CupDesc other = (CupDesc) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
	
	
}
