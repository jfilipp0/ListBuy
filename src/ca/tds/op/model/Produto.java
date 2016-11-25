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
 * MODEL DA CLASSE PRODUTO
 *
 */
@Entity(name = "PRODUTO")
public class Produto implements Serializable, Cloneable
{
	/* Atributos estáticos */
	private static final long serialVersionUID = 3119479208723474842L;
	
	/* CONTRUTOR */
	public Produto()
	{ }
	
	public Produto(String pNome, String pDescricao, String pImagem, String pFabricante)
	{
		nome = pNome;
		descricao = pDescricao;
		imagem = pImagem;
		fabricante = pFabricante;
	}
	
	/* ATRIBUTOS DA CLASSE */
	@Id()
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
	 @SequenceGenerator(name = "PRODUTO_SEQ", sequenceName = "PRODUTO_SEQ", allocationSize = 1)
	 @Column(name = "IDPRODUTO")
	private Integer idProduto;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "IMAGEM")
	private String imagem;
	
	@Column(name = "FABRICANTE")
	private String fabricante;
	
	//associaçoes
	@ManyToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "categoriaproduto",
	           joinColumns = { @JoinColumn(name = "PRODUTO_ID", nullable = false, updatable = false) },
	           inverseJoinColumns = { @JoinColumn(name = "CATEGORIA_ID", nullable = false, updatable = false) })//ManyToMany CATEGORIA
	private Set<Categoria> categorias;
	
	
	@ManyToMany(mappedBy = "produtos")//ManyToMany LOJA
	private Set<Loja> lojas;
	
	
	
	
	

	/* Getters & Setters */
	public Integer getIdProduto() {
		return this.idProduto;
	}
	public void setIdProduto(Integer pIdProduto) {
		this.idProduto = pIdProduto;
	}
	
	
	public String getNome() {
		return this.nome;
	}
	public void setNome(String pNome) 
	{
		this.nome = pNome;
	}
	
	
	public String getDescricao() 
	{
		return this.descricao;
	}
	public void setDescricao(String pDescricao) 
	{
		this.descricao = pDescricao;
	}
	
	
	public String getImagem() 
	{
		return this.imagem;
	}
	public void setImagem(String pImagem) 
	{
		this.imagem = pImagem;
	}
	
	
	public String getFabricante() 
	{
		return this.fabricante;
	}
	public void setFabricante(String pFabricante) 
	{
		this.fabricante = pFabricante;
	}
	
	
	public Set<Categoria> getCategorias() {
		return this.categorias;
	}
	public void setCategorias(Set<Categoria> pCategorias) {
		this.categorias = pCategorias;
	}
	
	
	public Set<Loja> getLojas() {
		return this.lojas;
	}
	public void setLojas(Set<Loja> pLoja) {
		this.lojas = pLoja;
	}
	
	
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.descricao == null) ? 0 : this.descricao.hashCode());
		result = prime * result + ((this.fabricante == null) ? 0 : this.fabricante.hashCode());
		result = prime * result + ((this.idProduto == null) ? 0 : this.idProduto.hashCode());
		result = prime * result + ((this.imagem == null) ? 0 : this.imagem.hashCode());
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
		Produto other = (Produto) obj;
		if (this.descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!this.descricao.equals(other.descricao))
			return false;
		if (this.fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!this.fabricante.equals(other.fabricante))
			return false;
		if (this.idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!this.idProduto.equals(other.idProduto))
			return false;
		if (this.imagem == null) {
			if (other.imagem != null)
				return false;
		} else if (!this.imagem.equals(other.imagem))
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
		return "Produto [idProduto=" + this.idProduto + ", nome=" + this.nome + ", descricao=" + this.descricao
				+ ", imagem=" + this.imagem + ", fabricante=" + this.fabricante + "]";
	}
	

}
