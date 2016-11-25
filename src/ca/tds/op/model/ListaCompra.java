package ca.tds.op.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * @author Thanatos
 * @version 0.0.1
 * MODEL DA CLASSE LISTA DE COMPRA
 *
 */
@Entity(name="LISTACOMPRA")
public class ListaCompra implements Serializable, Cloneable
{
	/* Atributos estáticos */
	private static final long serialVersionUID = -2426998487265933679L;
	
	/* CONTRUTOR */
	public ListaCompra()
	{ }
	
	public ListaCompra(Date pDataLista)
	{
		this.dataLista = pDataLista;
	}
	
	/* ATRIBUTOS DA CLASSE */
	@Id()
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LISTACOMPRA_SEQ")
	 @SequenceGenerator(name = "LISTACOMPRA_SEQ", sequenceName = "LISTACOMPRA_SEQ", allocationSize = 1)
	 @Column(name = "IDLISTACOMPRA")
	private Integer idListaCompra;
	
	@Column(name = "DATALISTACOMPRA")
	private Date dataLista;
	
	
	//associaçoes
	@OneToMany(targetEntity=Item.class, mappedBy="listaCompra",
			cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<Item> itens;
	
	
	@ManyToMany(mappedBy = "listasCompras")//ManyToMany Pessoa
	private Set<Pessoa> pessoas;

	
	
	
	
	/** Getters & Setters */
	public Integer getIdListaCompra() 
	{
		return this.idListaCompra;
	}
	public void setIdListaCompra(Integer pIdListaCompra) 
	{
		this.idListaCompra = pIdListaCompra;
	}
	
	
	public Date getDataLista() 
	{
		return this.dataLista;
	}
	public void setDataLista(Date pDataLista) 
	{
		this.dataLista = pDataLista;
	}
	
	
	public Set<Item> getItens() 
	{
		return this.itens;
	}
	public void setItens(Set<Item> pItem) 
	{
		this.itens = pItem;
	}
	
	
	
	public Set<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(Set<Pessoa> pPessoas) {
		this.pessoas = pPessoas;
	}
	
	
	

	/**
	 * HASHCODE
	 * EQUALS
	 * TOSTRING
	 */
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.dataLista == null) ? 0 : this.dataLista.hashCode());
		result = prime * result + ((this.idListaCompra == null) ? 0 : this.idListaCompra.hashCode());
		result = prime * result + ((this.itens == null) ? 0 : this.itens.hashCode());
		result = prime * result + ((this.pessoas == null) ? 0 : this.pessoas.hashCode());
		return result;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaCompra other = (ListaCompra) obj;
		if (this.dataLista == null) {
			if (other.dataLista != null)
				return false;
		} else if (!this.dataLista.equals(other.dataLista))
			return false;
		if (this.idListaCompra == null) {
			if (other.idListaCompra != null)
				return false;
		} else if (!this.idListaCompra.equals(other.idListaCompra))
			return false;
		if (this.itens == null) {
			if (other.itens != null)
				return false;
		} else if (!this.itens.equals(other.itens))
			return false;
		if (this.pessoas == null) {
			if (other.pessoas != null)
				return false;
		} else if (!this.pessoas.equals(other.pessoas))
			return false;
		return true;
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ListaCompra [idListaCompra=" + this.idListaCompra + ", dataLista=" + this.dataLista + ", item="
				+ this.itens + ", pessoa=" + this.pessoas + "]";
	}
	

}
