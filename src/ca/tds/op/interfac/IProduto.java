package ca.tds.op.interfac;

import java.util.List;

import ca.tds.op.model.Produto;

public interface IProduto 
{
	public Produto criar(Produto pProduto);
	public Produto recuperar(Integer pIdProduto);
	public Produto atualizar(Produto pProduto);
	public boolean deletar(Integer pIdProduto);
	public List<Produto> pesquisar();
	

}
