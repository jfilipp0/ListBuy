/**
 * 
 */
package ca.tds.op.dto;

import java.util.List;

import ca.tds.op.model.Categoria;

/**
 * @author Thanatos
 *
 */
public class CategoriaDTO extends AbstractDTO<Categoria>
{
	/* Construtores da classe */
	public CategoriaDTO()
	{
		super();
	}
	
	public CategoriaDTO(boolean pOk,String pMensagem)
	{
		super(pOk, pMensagem);
	}
	
	public CategoriaDTO(boolean pOk, String pMensagem, Categoria pCategoria)
	{
		super(pOk, pMensagem, pCategoria);
	}
	
	public CategoriaDTO(boolean pOk, String pMensagem, List<Categoria> pList)
	{
		super(pOk, pMensagem, pList);
	}
	
	/* Métodos de acesso */
	public Categoria getCategoria()
	{
		return getObjeto();
		
	}
	
	public void setCidade(Categoria pCategoria)
	{
		setObjeto(pCategoria);
		
	}

}
