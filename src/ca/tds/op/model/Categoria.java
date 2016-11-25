package ca.tds.op.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;



/**
 * @author Thanatos
 * @version 0.0.1
 * MODEL DA CLASSE CATEGORIA
 *
 */
@Entity(name="CATEGORIA")
public class Categoria implements Serializable, Cloneable
{
	/* Atributos estáticos */
	private static final long serialVersionUID = 3334923307499799735L;
	
	/* CONTRUTOR */
	public Categoria()
	{ }
	
	public Categoria(String pNome)
	{
		nome=pNome;
	}
	
	/* ATRIBUTOS DA CLASSE */
	@Id()
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIA_SEQ")
	 @SequenceGenerator(name = "CATEGORIA_SEQ", sequenceName = "CATEGORIA_SEQ", allocationSize = 1)
	 @Column(name = "IDCATEGORIA")
	private Integer idCategoria;
	
	@Column(name = "NOME")
	private String nome;
	
	//associaçao
	@ManyToMany(mappedBy = "categorias")
	private Set<Produto> produtos;

	
	
	
	
	/* Getters & Setters */
	public Integer getIdCategoria() 
	{
		return this.idCategoria;
	}
	public void setIdCategoria(Integer pIdCategoria) 
	{
		this.idCategoria = pIdCategoria;
	}
	
	
	public String getNome() 
	{
		return this.nome;
	}
	public void setNome(String pNome) 
	{
		this.nome = pNome;
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
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.idCategoria == null) ? 0 : this.idCategoria.hashCode());
		result = prime * result + ((this.nome == null) ? 0 : this.nome.hashCode());
		return result;
	}
	
	
	
	/* (non-Javadoc)
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
		Categoria other = (Categoria) obj;
		if (this.idCategoria == null) {
			if (other.idCategoria != null)
				return false;
		} else if (!this.idCategoria.equals(other.idCategoria))
			return false;
		if (this.nome == null) {
			if (other.nome != null)
				return false;
		} else if (!this.nome.equals(other.nome))
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Categoria [idCategoria=" + this.idCategoria + ", nome=" + this.nome + "]";
	}
	

}
