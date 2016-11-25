package ca.tds.op.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

/**
 * @author Thanatos
 * @version 0.0.1
 * MODEL DA CLASSE LOJA
 *
 */
@Entity(name = "LOJA")
public class Loja implements Serializable, Cloneable
{
	/* Atributos estáticos */
	private static final long serialVersionUID = -1749197412682899951L;
	
	/* CONTRUTOR */
	public Loja()
	{ }
	
	public Loja(String pNome, String pSite, String pLogomarca)
	{
		this.nome = pNome;
		this.site = pSite;
		this.logomarca = pLogomarca;
	}
	
	/* ATRIBUTOS DA CLASSE */
	@Id()
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOJA_SEQ")
	 @SequenceGenerator(name = "LOJA_SEQ", sequenceName = "LOJA_SEQ", allocationSize = 1)
	 @Column(name = "IDLOJA")
	private Integer idLoja;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "SITE")
	private String site;
	
	@Column(name = "LOGOMARCA")
	private String logomarca;
	
	//associativas
	@ManyToMany(cascade = CascadeType.DETACH)//ManyToMany LOJA
    @JoinTable(name = "produtoloja",
               joinColumns = { @JoinColumn(name = "LOJA_ID", nullable = false, updatable = false) },
               inverseJoinColumns = { @JoinColumn(name = "PRODUTO_ID", nullable = false, updatable = false) })
	private Set<Produto> produtos;
	

	/* Getters & Setters */
	public Integer getIdLoja() 
	{
		return this.idLoja;
	}
	public void setIdLoja(Integer pIdLoja) 
	{
		this.idLoja = pIdLoja;
	}
	
	
	
	public String getNome() 
	{
		return this.nome;
	}
	public void setNome(String pNome) 
	{
		this.nome = pNome;
	}
	
	
	public String getSite() 
	{
		return this.site;
	}
	public void setSite(String pSite) 
	{
		this.site = pSite;
	}
	
	
	public String getLogomarca() 
	{
		return this.logomarca;
	}
	public void setLogomarca(String pLogomarca) 
	{
		this.logomarca = pLogomarca;
	}
	
	
	public Set<Produto> getProdutos() 
	{
		return this.produtos;
	}
	public void setProdutos(Set<Produto> pProduto) 
	{
		this.produtos = pProduto;
	}
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.idLoja == null) ? 0 : this.idLoja.hashCode());
		result = prime * result + ((this.logomarca == null) ? 0 : this.logomarca.hashCode());
		result = prime * result + ((this.nome == null) ? 0 : this.nome.hashCode());
		result = prime * result + ((this.site == null) ? 0 : this.site.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Loja [idLoja=" + this.idLoja + ", nome=" + this.nome + ", site="
				+ this.site + ", logomarca=" + this.logomarca + "]";
	}
	
	/* (non-Javadoc)
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
		Loja other = (Loja) obj;
		if (this.idLoja == null) {
			if (other.idLoja != null)
				return false;
		} else if (!this.idLoja.equals(other.idLoja))
			return false;
		if (this.logomarca == null) {
			if (other.logomarca != null)
				return false;
		} else if (!this.logomarca.equals(other.logomarca))
			return false;
		if (this.nome == null) {
			if (other.nome != null)
				return false;
		} else if (!this.nome.equals(other.nome))
			return false;
		if (this.site == null) {
			if (other.site != null)
				return false;
		} else if (!this.site.equals(other.site))
			return false;
		
		return true;
	}
	

}
