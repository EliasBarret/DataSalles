package br.com.datasalles.domain;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Compra extends GenericDomain {
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date atual;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date vencimento;
		
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal precoTotal;
	
	@ManyToOne
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private TipoPagc tipopagc;
	
	@Fetch(FetchMode.SUBSELECT)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "compra")
	private List<ItemCompra>itensCompra;

	public Date getAtual() {
		return atual;
	}

	public void setAtual(Date atual) {
		this.atual = atual;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public TipoPagc getTipopagc() {
		return tipopagc;
	}

	public void setTipopagc(TipoPagc tipopagc) {
		this.tipopagc = tipopagc;
	}

	public List<ItemCompra> getItensCompra() {
		return itensCompra;
	}

	public void setItensCompra(List<ItemCompra> itensCompra) {
		this.itensCompra = itensCompra;
	}
	
		
}