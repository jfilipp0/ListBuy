/**
 * 
 */
package ca.tds.op.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * @author Thanatos
 *
 */
@Entity(name="ITEM")
public class Item implements Serializable, Cloneable
{
	
	private static final long serialVersionUID = -3659378870045011596L;
	
	/**
	 * Contrutor
	 */
	public Item() 
	{ }
	
	public Item(Double pDesconto, Double pPreco, Integer pQuantidade)
	{
		this.desconto=pDesconto;
		this.preco=pPreco;
		this.quantidade=pQuantidade;
		
	}
	
	/**
	 * atributos da classe
	 */
	@Id()
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ")
	 @SequenceGenerator(name = "ITEM_SEQ", sequenceName = "ITEM_SEQ", allocationSize = 1)
	 @Column(name = "IDITEM")
	private Integer idItem;
	
	@Column(name = "DESCONTO")
	private Double desconto;
	
	@Column(name = "PRECO")
	private Double preco;

	@Column(name = "QUANTIDADE")
	private Integer quantidade;
	
	//associaçao
	
	@ManyToOne
	@JoinColumn(name = "LISTACOMPRA_ID")
	private ListaCompra listaCompra;
	
	@ManyToOne
	@JoinColumn(name = "PRODUTO_ID")
	private Produto produtos;
	
	@ManyToOne
	@JoinColumn(name = "LOJA_ID")
	private Loja lojas;
	
	
	/**
	 * Getters and Setters
	 */
	public Integer getIdItem() 
	{
		return this.idItem;
	}
	public void setIdItem(Integer pIdItem) 
	{
		this.idItem = pIdItem;
	}
	
	
	public Double getDesconto() {
		return this.desconto;
	}
	public void setDesconto(Double pDesconto) {
		this.desconto = pDesconto;
	}
	
	
	public Double getPreco() 
	{
		return this.preco;
	}
	public void setPreco(Double pPreco) 
	{
		this.preco = pPreco;
	}
	
	
	public Integer getQuantidade() 
	{
		return this.quantidade;
	}
	public void setQuantidade(Integer pQuantidade) 
	{
		this.quantidade = pQuantidade;
	}
	
	//associacao
	
	public ListaCompra getListaCompra() 
	{
		return this.listaCompra;
	}
	public void setListaCompra(ListaCompra pListaCompra) 
	{
		this.listaCompra = pListaCompra;
	}
	
	
	public Produto getProdutos() 
	{
		return this.produtos;
	}
	public void setProdutos(Produto pProdutos) 
	{
		this.produtos = pProdutos;
	}

	
	public Loja getLojas() 
	{
		return this.lojas;
	}
	public void setLojas(Loja pLojas) 
	{
		this.lojas = pLojas;
	}

	/**
	 * - Hashcode 
	 * - Equals 
	 * - ToString
	 */
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.idItem == null) ? 0 : this.idItem.hashCode());
		result = prime * result + ((this.listaCompra == null) ? 0 : this.listaCompra.hashCode());
		result = prime * result + ((this.preco == null) ? 0 : this.preco.hashCode());
		result = prime * result + ((this.quantidade == null) ? 0 : this.quantidade.hashCode());
		return result;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (this.idItem == null) {
			if (other.idItem != null)
				return false;
		} else if (!this.idItem.equals(other.idItem))
			return false;
		if (this.listaCompra == null) {
			if (other.listaCompra != null)
				return false;
		} else if (!this.listaCompra.equals(other.listaCompra))
			return false;
		if (this.preco == null) {
			if (other.preco != null)
				return false;
		} else if (!this.preco.equals(other.preco))
			return false;
		if (this.quantidade == null) {
			if (other.quantidade != null)
				return false;
		} else if (!this.quantidade.equals(other.quantidade))
			return false;
		return true;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Item [idItem=" + this.idItem + ", preco=" + this.preco + ", quantidade=" + this.quantidade
				+ ", listaCompra=" + this.listaCompra + "]";
	}
	

}
