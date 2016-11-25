package ca.tds.op.interfac;

import java.util.List;

import ca.tds.op.model.Pessoa;

public interface IPessoa 
{
	public Pessoa criar(Pessoa pPessoa);
	public Pessoa recuperar(String pEmail);
	public Pessoa atualizar(Pessoa pPessoa);
	public boolean deletar(String pEmail);
	public List<Pessoa> pesquisar();
	public List<Pessoa> pesquisarEmail(String pEmail);
	public Pessoa login(String pEmail,String pSenha);
	public Pessoa logout();
	

}
