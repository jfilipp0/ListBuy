/**
 * 
 */
package ca.tds.op.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


/**
 * @author Thanatos
 * @version 0.0.1
 * MODEL DA CLASSE PESSOA
 */
@Entity(name="PESSOA")
public class Pessoa implements Serializable, Cloneable 
{
	/* Atributos estáticos */
	private static final long serialVersionUID = 3342920309300420829L;

	/* CONTRUTOR */
	public Pessoa()
	{ }
	
	public Pessoa(String pEmail,String pSenha,String pNome,String pTelefone,Date pDtNascimento,String pPrivilegio)
	{
		this.email = pEmail;
		this.senha = pSenha;
		this.nome = pNome;
		this.telefone = pTelefone;
		this.dtNascimento = pDtNascimento;
		this.privilegio = pPrivilegio;
		
	}
	
	/* ATRIBUTOS DA CLASSE */
	@Id()
	 @Column(name = "EMAIL")
	private String email;
	
	@Column(name = "SENHA")
	private String senha;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "DTNASC")
	private Date dtNascimento;
	
	@Column(name = "PRIVILEGIO")
	private String privilegio;
	
	//associação
	
	@ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "PESSOALISTACOMPRA",
               joinColumns = { @JoinColumn(name = "PESSOA_EMAIL", nullable = false, updatable = false) },
               inverseJoinColumns = { @JoinColumn(name = "LISTACOMPRA_ID", nullable = false, updatable = false) })
	private Set<ListaCompra> listasCompras;
	
	
	
	
	/* Getters & Setters */
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	
	public String getSenha() 
	{
		return this.senha;
	}
	public void setSenha(String pSenhap) 
	{
		this.senha = pSenhap;
	}
	
	
	public String getTelefone() 
	{
		return telefone;
	}
	public void setTelefone(String telefone) 
	{
		this.telefone = telefone;
	}
	
	
	public Date getDtNascimento() 
	{
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) 
	{
		this.dtNascimento = dtNascimento;
	}
	
	
	public String getPrivilegio() 
	{
		return privilegio;
	}
	public void setPrivilegio(String privilegio) 
	{
		this.privilegio = privilegio;
	}
	
	
	public Set<ListaCompra> getListasCompras() {
		return this.listasCompras;
	}
	public void setListasCompras(Set<ListaCompra> pListaCompra) {
		this.listasCompras = pListaCompra;
	}
	
	
	
	
	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.dtNascimento == null) ? 0 : this.dtNascimento.hashCode());
		result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
		result = prime * result + ((this.nome == null) ? 0 : this.nome.hashCode());
		result = prime * result + ((this.privilegio == null) ? 0 : this.privilegio.hashCode());
		result = prime * result + ((this.senha == null) ? 0 : this.senha.hashCode());
		result = prime * result + ((this.telefone == null) ? 0 : this.telefone.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (this.dtNascimento == null) 
		{
			if (other.dtNascimento != null)
				return false;
		} else if (!this.dtNascimento.equals(other.dtNascimento))
			return false;
		if (this.email == null) 
		{
			if (other.email != null)
				return false;
		} else if (!this.email.equals(other.email))
			return false;
		if (this.nome == null) 
		{
			if (other.nome != null)
				return false;
		} else if (!this.nome.equals(other.nome))
			return false;
		if (this.privilegio == null) 
		{
			if (other.privilegio != null)
				return false;
		} else if (!this.privilegio.equals(other.privilegio))
			return false;
		if (this.senha == null) 
		{
			if (other.senha != null)
				return false;
		} else if (!this.senha.equals(other.senha))
			return false;
		if (this.telefone == null) 
		{
			if (other.telefone != null)
				return false;
		} else if (!this.telefone.equals(other.telefone))
			return false;
		return true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return "Pessoa [email=" + this.email + ", senha=" + this.senha + ", nome=" + this.nome + ", telefone="
				+ this.telefone + ", dtNascimento=" + this.dtNascimento + ", privilegio=" + this.privilegio
				+  "]";
	}
	

}
