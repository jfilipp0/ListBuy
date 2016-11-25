/**
 * 
 */
package ca.tds.op.dto;

import java.util.List;

import ca.tds.op.model.Produto;

/**
 * @author Thanatos
 *
 */
public class ProdutoDTO extends AbstractDTO<Produto>
{
	/* Construtores da classe */
	public ProdutoDTO()
	{
		super();
	}
	
	public ProdutoDTO(boolean pOk,String pMensagem)
	{
		super(pOk,pMensagem);
	}
	
	public ProdutoDTO(boolean pOk, String pMensagem, Produto pProduto)
	{
		super(pOk,pMensagem,pProduto);
	}
	
	public ProdutoDTO(boolean pOk, String pMensagem, List<Produto> pList)
	{
		super(pOk,pMensagem,pList);
	}
	
	/* Métodos de acesso */
	public Produto getProduto()
	{
		return getObjeto();
		
	}
	
	public void setProduto(Produto pProduto)
	{
		setObjeto(pProduto);
		
	}

}
